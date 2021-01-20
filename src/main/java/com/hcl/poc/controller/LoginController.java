package com.hcl.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

import com.hcl.poc.dto.login.Login;
import com.hcl.poc.dto.login.LoginResponse;
import com.hcl.poc.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = CorsConfiguration.ALL)
@Validated
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody Login  login) {
		return ResponseEntity.ok(loginService.doLogin(login));
	}
}
