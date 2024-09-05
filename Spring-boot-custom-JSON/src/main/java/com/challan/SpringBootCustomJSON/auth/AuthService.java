package com.challan.SpringBootCustomJSON.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.challan.SpringBootCustomJSON.config.JWTUtil;

@Service
public class AuthService {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public String authenticateUser(String username, String password) {
		// Validate username and password (in a real application, check against a
		// database)
		if ("faiz".equals(username) && "iva@123".equals(password)) { // Replace with actual validation
			String token = jwtUtil.generateToken(username);
			redisTemplate.opsForValue().set(token, username);
			return token;
		} else {
			throw new RuntimeException("Invalid credentials");
		}
	}
}
