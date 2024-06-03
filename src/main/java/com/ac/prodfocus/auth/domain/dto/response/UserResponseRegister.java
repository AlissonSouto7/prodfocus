package com.ac.prodfocus.auth.domain.dto.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseRegister {
	private UUID idUser;
	private String token;
}
