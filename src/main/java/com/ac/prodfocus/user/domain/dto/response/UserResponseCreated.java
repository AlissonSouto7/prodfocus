package com.ac.prodfocus.user.domain.dto.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseCreated {
	private UUID idUser;
}
