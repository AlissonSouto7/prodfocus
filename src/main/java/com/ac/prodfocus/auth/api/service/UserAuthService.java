package com.ac.prodfocus.auth.api.service;

import com.ac.prodfocus.auth.domain.dto.request.UserRequestLogin;
import com.ac.prodfocus.auth.domain.dto.request.UserRequestRegister;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseLogin;
import com.ac.prodfocus.auth.domain.dto.response.UserResponseRegister;

public interface UserAuthService {

	UserResponseRegister registra(UserRequestRegister request);
	
	UserResponseLogin login(UserRequestLogin request);
}
