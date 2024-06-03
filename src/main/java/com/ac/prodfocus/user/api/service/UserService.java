package com.ac.prodfocus.user.api.service;

import java.util.UUID;

import com.ac.prodfocus.user.domain.dto.request.UserRequestUpdate;
import com.ac.prodfocus.user.domain.dto.response.UserResponse;

import jakarta.validation.Valid;

public interface UserService {

	UserResponse getUser(UUID idUser);

	void updateUser(@Valid UserRequestUpdate updateRequest, UUID idUser);

	void deleteUser(UUID idUser);

}
