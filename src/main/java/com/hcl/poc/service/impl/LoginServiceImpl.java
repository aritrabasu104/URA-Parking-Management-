package com.hcl.poc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.poc.dto.login.Login;
import com.hcl.poc.dto.login.LoginResponse;
import com.hcl.poc.model.AppUser;
import com.hcl.poc.repository.UserRepository;
import com.hcl.poc.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public LoginResponse doLogin(Login login) {
		log.info("validating {}",login);
		
		LoginResponse loginResponse = new LoginResponse();
		
		Optional<AppUser> users = userRepository.validateLoginUser(login.getUserName(), login.getPassword());
		
		if(users.isPresent()) {
			AppUser user = users.get();
			
			loginResponse.setResponseMessage("Welcome " + user.getApplicantName());
			loginResponse.setResponseStatus("OK");
			loginResponse.setUserName(user.getApplicantName());
			loginResponse.setUserId(user.getId().toString());
			log.info("login successful for {}", login);
		} else {
			loginResponse.setResponseMessage("Invalid Username or Password");
			loginResponse.setResponseStatus("FAIL");
			log.error("invalid credentials {}",login);
			
		} 
		
		return loginResponse ;
	}

}
