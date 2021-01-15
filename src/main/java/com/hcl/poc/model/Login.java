package com.hcl.poc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel
public class Login {
	
	@ApiModelProperty(notes = "Name of the user")
	private String userName;
	
	@ApiModelProperty(notes = "Password")
	private String password;

	public Login() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
