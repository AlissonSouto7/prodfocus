package com.ac.prodfocus.user.api.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.ac.prodfocus.user.api.service.UserService;
import com.ac.prodfocus.user.domain.dto.request.UserRequestNew;
import com.ac.prodfocus.user.domain.dto.request.UserRequestUpdate;
import com.ac.prodfocus.user.domain.dto.response.UserResponse;
import com.ac.prodfocus.user.domain.dto.response.UserResponseCreated;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserImplController implements UserController {

	private final UserService userService;

	@Override
	public UserResponseCreated createNewUser(@Valid UserRequestNew newRequest) {
		log.info("[START] UserImplController - createNewUser");

		UserResponseCreated response = userService.registerUser(newRequest);
		
		log.info("[FINISH] UserImplController - createNewUser");
		return response;
	}

	@Override
	public UserResponse getUserById(UUID idUser) {
		log.info("[START] UserImplController - getUserById");
		
		UserResponse response = userService.getUser(idUser);
		
		log.info("[FINISH] UserImplController - getUserById");
		return response;
	}

	@Override
	public void updateUserById(@Valid UserRequestUpdate updateRequest, UUID idUser) {
		log.info("[START] UserImplController - updateUser");
		
		userService.updateUser(updateRequest, idUser);
		
		log.info("[FINISH] UserImplController - updateUser");
	}

	@Override
	public void deleteUserById(UUID idUser) {
		log.info("[START] UserImplController - deleteUser");
		
		userService.deleteUser(idUser);
		
		log.info("[FINISH] UserImplController - deleteUser");
	}
}