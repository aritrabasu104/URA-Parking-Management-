package com.hcl.poc.service.impl;

import org.springframework.stereotype.Service;

import com.hcl.poc.dto.Login;
import com.hcl.poc.dto.LoginResponse;
import com.hcl.poc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public LoginResponse doLogin(Login login) {
		
		LoginResponse loginResponse = new LoginResponse();
		
		if(("admin".equals(login.getUserName()) && "admin123".equals(login.getPassword())) || 
				("user".equals(login.getUserName()) && "user123".equals(login.getPassword()))) {

			loginResponse.setResponseCode("200");
			loginResponse.setResponseMessage("Welcome " + login.getUserName());
			loginResponse.setResponseStatus("OK");
			loginResponse.setUserName(login.getUserName());

		} else {
			loginResponse.setResponseCode("400");
			loginResponse.setResponseMessage("Invalid Username or Password");
			loginResponse.setResponseStatus("FAIL");
		}
		return loginResponse ;
	}

}
