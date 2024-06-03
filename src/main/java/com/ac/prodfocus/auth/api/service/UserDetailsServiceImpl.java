package com.ac.prodfocus.auth.api.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ac.prodfocus.auth.domain.UserCredentials;
import com.ac.prodfocus.user.infra.UserJPARepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserJPARepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByEmail(username).map(UserCredentials::new)
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado com o email " + username));
	}
}