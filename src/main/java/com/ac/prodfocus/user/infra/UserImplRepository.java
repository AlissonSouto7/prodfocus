package com.ac.prodfocus.user.infra;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ac.prodfocus.user.api.repository.UserRepository;
import com.ac.prodfocus.user.domain.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UserImplRepository implements UserRepository {
	
	private final UserJPARepository repository;
	
	@Override
	public User saveUser(User user) {
		log.info("[START] UserImplRepository - saveUser");
		
		User userSalvo = repository.save(user);
		
		log.info("[FINISH] UserImplRepository - saveUser");
		return userSalvo;
	}

	@Override
	public User getUserById(UUID idUser) {
		log.info("[START] UserImplRepository - getUserById");
		
		User userOptional = repository.findById(idUser).orElseThrow(
				() -> new RuntimeException("Usuario não encontrado com o id " + idUser));
		
		log.info("[FINISH] UserImplRepository - getUserById");
		return userOptional;
	}

	@Override
	public void deleteUser(User user) {
		log.info("[START] UserImplRepository - deleteUser");
		
		repository.delete(user);
		
		log.info("[FINISH] UserImplRepository - deleteUser");
	}
}