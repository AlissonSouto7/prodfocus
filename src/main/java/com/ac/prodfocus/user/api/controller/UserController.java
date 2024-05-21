package com.ac.prodfocus.user.api.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ac.prodfocus.user.domain.dto.request.UserRequestNew;
import com.ac.prodfocus.user.domain.dto.request.UserRequestUpdate;
import com.ac.prodfocus.user.domain.dto.response.UserResponse;
import com.ac.prodfocus.user.domain.dto.response.UserResponseCreated;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/user")
public interface UserController {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserResponseCreated createNewUser(@RequestBody @Valid UserRequestNew newRequest);

	@GetMapping("/{idUser}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserResponse getUserById(@PathVariable UUID idUser); 
	
	@PutMapping("/{idUser}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateUserById(@RequestBody @Valid UserRequestUpdate updateRequest, @PathVariable UUID idUser);

	@DeleteMapping("/{idUser}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUserById(@PathVariable UUID idUser);
}