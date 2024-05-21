package com.ac.prodfocus.user.domain.dto.response;

import java.util.UUID;

import com.ac.prodfocus.user.domain.User;
import com.ac.prodfocus.user.domain.enuns.Sexo;

import lombok.Data;

@Data
public class UserResponse {

	private UUID idUser;
	private String name;
	private String email;
	private Sexo sexo;
	
	public UserResponse(User userResponse) {
		this.idUser = userResponse.getIdUser();
		this.name = userResponse.getNome();
		this.email = userResponse.getEmail();
		this.sexo = userResponse.getSexo();
	}
}