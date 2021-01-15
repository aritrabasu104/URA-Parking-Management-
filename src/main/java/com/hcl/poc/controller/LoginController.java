package com.hcl.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.poc.common.Validator;
import com.hcl.poc.dto.Login;
import com.hcl.poc.dto.LoginResponse;
import com.hcl.poc.model.AppUser;
import com.hcl.poc.service.LoginService;
import com.hcl.poc.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private Validator validator;
	
	@GetMapping("/user")
	public ResponseEntity<AppUser> createUser() {
		return ResponseEntity.ok(userService.createUser());
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody Login  login) {
		LoginResponse loginResponse = validator.validateLoginUser(login);
		
		if("FAIL".equalsIgnoreCase(loginResponse.getResponseStatus()))
			return ResponseEntity.ok(loginResponse);
		else
			return ResponseEntity.ok(loginService.doLogin(login));
	}
}
