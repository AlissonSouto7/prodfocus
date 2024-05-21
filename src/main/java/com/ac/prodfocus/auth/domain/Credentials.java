package com.ac.prodfocus.auth.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Entity
public class Credentials {
	@Id
	@Getter
	@Email
	private String email;
	
	private String senha;

	public Credentials(String email, String senha) {
		this.email = email;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}
	
	public String getPassword() {
		return senha;
	}
}