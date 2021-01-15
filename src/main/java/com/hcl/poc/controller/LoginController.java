package com.hcl.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

import com.hcl.poc.common.Validator;
import com.hcl.poc.dto.Login;
import com.hcl.poc.dto.LoginResponse;
import com.hcl.poc.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = CorsConfiguration.ALL)
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private Validator validator;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody Login  login) {
		LoginResponse loginResponse = validator.validateLoginUser(login);
		
		if("FAIL".equalsIgnoreCase(loginResponse.getResponseStatus()))
			return ResponseEntity.ok(loginResponse);
		else
			return ResponseEntity.ok(loginService.doLogin(login));
	}
}
