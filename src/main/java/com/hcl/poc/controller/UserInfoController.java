package com.hcl.poc.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.poc.service.UserService;

@RestController
public class UserInfoController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserService userService;

	
}
