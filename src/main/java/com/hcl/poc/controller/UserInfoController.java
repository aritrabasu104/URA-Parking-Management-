package com.hcl.poc.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.poc.dto.MyInfoRequestDto;
import com.hcl.poc.dto.UserResponseDto;
import com.hcl.poc.service.UserService;

@RestController
public class UserInfoController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserService userService;

	@PostMapping("/get/myinfo")
	public ResponseEntity<UserResponseDto> getMyInfo(@Valid @RequestBody MyInfoRequestDto myInfoRequestDto) {
		
		return ResponseEntity.ok(modelMapper.map(userService.getUserInfo(myInfoRequestDto.getUserId()), UserResponseDto.class));
	}
}
