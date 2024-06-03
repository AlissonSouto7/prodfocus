package com.ac.prodfocus.auth.api.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ac.prodfocus.auth.domain.dto.request.UserRequestLogin;
import com.ac.prodfocus.auth.domain.dto.request.UserRequestRegister;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseLogin;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseRegister;
import com.ac.prodfocus.user.api.repository.UserRepository;
import com.ac.prodfocus.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {
	
	private final UserRepository repository;
	private final JwtService jwtService;
	
	@Override
	public UserResponseRegister registra(UserRequestRegister request) {
	
		if(repository.findByUsername(request.getEmail()).isPresent()) {
			throw new RuntimeException("O e-mail " + request.getEmail() + " já está em uso.");
		}
		User user = repository.saveUser(new User(request));
		
		String token = jwtService.generateToken(user.getEmail());
		
		return UserResponseRegister.builder().idUser(user.getIdUser()).token(token).build();
	}

	@Override
	public UserResponseLogin login(UserRequestLogin request) {
		
		var user = repository.findByUsername(request.getEmail());
		
		if(user.isEmpty() || !user.get().checksCredentials(request, new BCryptPasswordEncoder())){
			throw new RuntimeException("Email ou Senha Invalido!");
		}
		
		String token = jwtService.generateToken(request.getEmail());
		
		return UserResponseLogin.builder().token(token).build();
	}
}