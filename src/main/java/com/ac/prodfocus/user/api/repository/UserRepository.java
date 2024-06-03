package com.ac.prodfocus.user.api.repository;

import java.util.Optional;
import java.util.UUID;

import com.ac.prodfocus.user.domain.User;

public interface UserRepository {
	User saveUser(User user);

	User getUserById(UUID idUser);

	void deleteUser(User user);

	Optional<User> findByUsername(String email);
}