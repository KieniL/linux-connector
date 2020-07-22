package com.kienast.authservice.service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class TokenServiceImpl implements TokenService {

	private static final String SECRET = "mySecretKey";
	private static final String AUTHORITIES_KEY = "auth";

	@Override
	public String generateToken(String userId) {
		String authorities = "ROLE_SERVICE";

		ZonedDateTime now = ZonedDateTime.now();
		ZonedDateTime expirationDateTime = now.plus(31536000000L, ChronoUnit.MILLIS);

		Date issueDate = Date.from(now.toInstant());
		Date expirationDate = Date.from(expirationDateTime.toInstant());

		return Jwts.builder().setSubject(userId).claim(AUTHORITIES_KEY, authorities)
				.signWith(SignatureAlgorithm.HS512, SECRET).setIssuedAt(issueDate).setExpiration(expirationDate)
				.compact();
	}

	@Override
	public boolean validateToken(String jwtToken) {
		try {
			Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
			return true;
		} catch (SignatureException e) {
			return false;
		} catch (MalformedJwtException e) {
			return false;
		}
	}

	@Override
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
		Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
		if (claims.get(AUTHORITIES_KEY) != null) {
			authorities = Arrays.asList(claims.get(AUTHORITIES_KEY).toString().split(",")).stream()
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		}
		User principal = new User(claims.getSubject(), "", authorities);

		return new UsernamePasswordAuthenticationToken(principal, "", authorities);
	}

}
