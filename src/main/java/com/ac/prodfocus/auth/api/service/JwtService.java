package com.ac.prodfocus.auth.api.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.ac.prodfocus.user.domain.User;
import com.ac.prodfocus.user.infra.UserJPARepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {
	
	private final UserJPARepository repository;
	private final JwtEncoder encoder;
	
	public String generateToken(String email) {
		
		//definindo o horario que for gerado o token
		Instant now = Instant.now();
		
		//definindo 5 minutos
		Long expiry = 300000L;
		
		//Trazendo o usuario autenticado para passar o id no token
		Optional<User> user = repository.findByEmail(email);
		
		var claims = JwtClaimsSet.builder()
				//dizendo que é o gerador do token
				.issuer("ProdFocus-BE")
				//passando o horario atual da geração do token
				.issuedAt(now)
				//definindo o tempo de duração do token hora atual + 5 minutos
				.expiresAt(now.plusSeconds(expiry))
				//passando o id do usuario no token
				.subject(user.get().getIdUser().toString())
				.build();
		
		//codificando o token
		return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}
}