package com.ac.prodfocus.auth.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ac.prodfocus.auth.domain.dto.request.UserRequestLogin;
import com.ac.prodfocus.auth.domain.dto.request.UserRequestRegister;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseLogin;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseRegister;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public interface UserAuthController {
	
	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserResponseRegister register(@RequestBody @Valid UserRequestRegister requestRegister);

	@PostMapping("/login")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserResponseLogin login(@RequestBody @Valid UserRequestLogin requestLogin);
}
