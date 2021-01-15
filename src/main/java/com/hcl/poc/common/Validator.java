package com.hcl.poc.common;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.hcl.poc.dto.Login;
import com.hcl.poc.dto.LoginResponse;

@Component
public class Validator {

	public Validator() {

	}
	
	public LoginResponse validateLoginUser(Login login) {
		LoginResponse loginResponse = new LoginResponse();
		
		if(login.getUserName().isEmpty() || login.getPassword().isEmpty() || Objects.isNull(login.getUserName()) || Objects.isNull(login.getPassword())) {
			
			loginResponse.setResponseCode("400");
			loginResponse.setResponseMessage("Please provide a Valid Username and Password.");
			loginResponse.setResponseStatus("FAIL");
		}
		
		return loginResponse;
	}
}
