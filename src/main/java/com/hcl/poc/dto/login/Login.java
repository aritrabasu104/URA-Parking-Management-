package com.hcl.poc.dto.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Login {
	
	@ApiModelProperty(required = true, notes = "Name of the user")
	private String userName;
	
	@ApiModelProperty(required = true, notes = "Password")
	private String password;

	public Login() {

	}
}
