package com.hcl.poc.dto.login;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginResponse {
	private String userName;
	
	private String responseStatus;
	
	private String responseCode;
	
	private String responseMessage;
	
	private String userId;

}
