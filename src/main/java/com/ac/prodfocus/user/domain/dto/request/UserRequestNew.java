package com.ac.prodfocus.user.domain.dto.request;

import com.ac.prodfocus.user.domain.enuns.Sexo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestNew {
	
	@NotBlank
	private String email;

	@NotBlank
	private String nome;
	
	@NotNull
	private Sexo sexo;
}