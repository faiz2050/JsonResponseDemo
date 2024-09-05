package com.challan.SpringBootCustomJSON.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challan.SpringBootCustomJSON.auth.AuthService;
import com.challan.SpringBootCustomJSON.model.Employee;

@RestController
public class ChallanController {

	private static final Logger log = LoggerFactory.getLogger(ChallanController.class);

	@RequestMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return Employee.getEmployee();
	}

	@PostMapping("/accept-json")
	public ResponseEntity<String> acceptJson(Object jsonObject) {

		if (jsonObject == null) {
			log.info("Invalid JSON received !!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON !");
		}

		log.info("Challan request received");
		return ResponseEntity.status(HttpStatus.OK) // Set the status code to 200 OK
				.body("OK"); // Set the response body
	}

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		return authService.authenticateUser(username, password);
	}
}
