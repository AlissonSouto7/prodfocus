package com.ac.prodfocus.user.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ac.prodfocus.user.domain.User;

public interface UserJPARepository extends JpaRepository<User, UUID>{
	Optional<User> findByEmail(String email);
}
