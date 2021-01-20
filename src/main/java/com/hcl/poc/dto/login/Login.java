package com.hcl.poc.dto.login;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Login {
	
	@ApiModelProperty(required = true, notes = "Name of the user")
	@NotBlank
	private String userName;
	
	@ApiModelProperty(required = true, notes = "Password")
	@NotBlank
	private String password;

}
