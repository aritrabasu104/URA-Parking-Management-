package com.hcl.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.poc.model.AppUser;
import com.hcl.poc.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private UserService userService;
	@GetMapping("/user")
	public ResponseEntity<AppUser> createUser() {
		return ResponseEntity.ok(userService.createUser());
	}
}
