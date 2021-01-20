package com.hcl.poc.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.poc.common.Validator;
import com.hcl.poc.dto.login.Login;
import com.hcl.poc.dto.login.LoginResponse;
import com.hcl.poc.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;
	
	@Mock
	LoginService loginService;
	
	@Mock
	private Validator validator;
	
	@Test
	public void doLoginTest() {
		when(loginService.doLogin(getLoginRequest())).thenReturn(getLoginResponse());
		
		ResponseEntity<LoginResponse> response = loginController.login(getLoginRequest());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	public Login getLoginRequest() {
		Login login = new Login();
		
		login.setPassword("password");
		login.setUserName("test");
		
		return login;
	}
	
	public LoginResponse getLoginResponse() {
		LoginResponse loginResponse = new LoginResponse();

		loginResponse.setResponseCode("200");
		loginResponse.setResponseMessage("Welcome");
		loginResponse.setResponseStatus("OK");
		
		return loginResponse;
		
	}
}
