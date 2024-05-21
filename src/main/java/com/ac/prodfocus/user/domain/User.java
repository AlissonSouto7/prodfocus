package com.ac.prodfocus.user.domain;

import java.util.UUID;

import com.ac.prodfocus.user.domain.dto.request.UserRequestNew;
import com.ac.prodfocus.user.domain.dto.request.UserRequestUpdate;
import com.ac.prodfocus.user.domain.enuns.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idUser;

	@Email
	@Column(unique = true)
	private String email;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	public User(@Valid UserRequestNew newRequest) {
		this.email = newRequest.getEmail();
		this.nome = newRequest.getNome();
		this.sexo = newRequest.getSexo();
	}

	public void atualiza(@Valid UserRequestUpdate updateRequest) {
		this.nome = updateRequest.getNome();
		this.sexo = updateRequest.getSexo();
	}
}