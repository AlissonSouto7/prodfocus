package com.ac.prodfocus.user.api.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ac.prodfocus.user.api.repository.UserRepository;
import com.ac.prodfocus.user.domain.User;
import com.ac.prodfocus.user.domain.dto.request.UserRequestUpdate;
import com.ac.prodfocus.user.domain.dto.response.UserResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserImplService implements UserService {
	
	private final UserRepository repository;

	@Override
	public UserResponse getUser(UUID idUser) {
		log.info("[START] UserImplService - getUser");
		
		User userResponse = repository.getUserById(idUser);
	
		log.info("[FINISH] UserImplService - getUser");
		return new UserResponse(userResponse);
	}

	@Override
	public void updateUser(@Valid UserRequestUpdate updateRequest, UUID idUser) {
		log.info("[START] UserImplService - updateUser");
		
		User userOptional = repository.getUserById(idUser);
		userOptional.atualiza(updateRequest);
		repository.saveUser(userOptional);
	
		log.info("[FINISH] UserImplService - updateUser");
	}

	@Override
	public void deleteUser(UUID idUser) {
		log.info("[START] UserImplService - deleteUser");
		
		User userOptional = repository.getUserById(idUser);
		repository.deleteUser(userOptional);
	
		log.info("[FINISH] UserImplService - deleteUser");
	}
}