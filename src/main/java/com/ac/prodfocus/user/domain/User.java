package com.ac.prodfocus.user.domain;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ac.prodfocus.auth.domain.dto.request.UserRequestLogin;
import com.ac.prodfocus.auth.domain.dto.request.UserRequestRegister;
import com.ac.prodfocus.user.domain.dto.request.UserRequestUpdate;
import com.ac.prodfocus.user.domain.enuns.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "tb_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID idUser;

	@Email
	@Column(unique = true)
	private String email;
	
	private String password;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	public void atualiza(@Valid UserRequestUpdate updateRequest) {
		this.nome = updateRequest.getNome();
		this.sexo = updateRequest.getSexo();
	}

	public User(@Valid UserRequestRegister request) {
		this.email = request.getEmail();
		this.password = new BCryptPasswordEncoder().encode(request.getPassword());
		this.nome = request.getNome();
		this.sexo = request.getSexo();
	}

	public boolean checksCredentials(UserRequestLogin request, PasswordEncoder encoder) {
		return encoder.matches(request.getPassword(), this.password);
	}
}