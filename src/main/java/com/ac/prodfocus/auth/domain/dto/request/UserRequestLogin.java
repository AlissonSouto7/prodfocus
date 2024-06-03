package com.ac.prodfocus.auth.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestLogin {

	@NotBlank
	private String email;

	@NotBlank
	private String password;
}