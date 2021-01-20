package com.hcl.poc.dto.login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Login {
	
	@NotBlank
	@ApiModelProperty(required = true, notes = "Name of the user")
	private String userName;
	
	@NotBlank
	@ApiModelProperty(required = true, notes = "Password")
	private String password;

	public Login() {

	}
}
