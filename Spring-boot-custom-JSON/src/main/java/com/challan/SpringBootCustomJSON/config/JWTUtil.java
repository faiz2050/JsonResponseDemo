package com.challan.SpringBootCustomJSON.config;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	private String secretKey = "john-tokens-key"; // Replace with a secure key
	private long validityInMilliseconds = 3600000; // 1 hour

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username) // Set the subject (usually the username)
				.setIssuedAt(new Date()) // Set the issued date
				.signWith(SignatureAlgorithm.HS256, secretKey.getBytes()) // Sign the token with the secret key
				.compact(); // Compact the JWT to a string
	}

	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	public boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}

	public boolean validateToken(String token, String username) {
		return (username.equals(getUsername(token)) && !isTokenExpired(token));
	}
}
