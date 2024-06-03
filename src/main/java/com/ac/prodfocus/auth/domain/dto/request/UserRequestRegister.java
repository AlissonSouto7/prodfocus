package com.ac.prodfocus.auth.domain.dto.request;

import com.ac.prodfocus.user.domain.enuns.Sexo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestRegister {
	
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String nome;

    @NotNull
    private Sexo sexo;
}