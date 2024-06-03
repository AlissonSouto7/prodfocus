package com.ac.prodfocus.auth.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseLogin {
	private String token;
}
