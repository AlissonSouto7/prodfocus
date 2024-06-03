package com.ac.prodfocus.auth.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ac.prodfocus.auth.api.service.UserAuthService;
import com.ac.prodfocus.auth.domain.dto.request.UserRequestLogin;
import com.ac.prodfocus.auth.domain.dto.request.UserRequestRegister;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseLogin;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseRegister;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserAuthControllerImpl implements UserAuthController {

	private final UserAuthService service;
	
	@Override
	public UserResponseRegister register(UserRequestRegister request) {
		UserResponseRegister registeredUser = service.registra(request);
		return registeredUser;
	}

	@Override
	public UserResponseLogin login(UserRequestLogin request) {
		UserResponseLogin loggedInUser = service.login(request);
		return loggedInUser;
	}
}