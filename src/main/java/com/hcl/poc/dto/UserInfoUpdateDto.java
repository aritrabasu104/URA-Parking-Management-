package com.hcl.poc.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserInfoUpdateDto {
	private UUID id;
	
	private String registeredAddress;
	
	private String mailingAddress;
	
	@NotBlank
	private String emailId;
	
	private String contactNo;
	
	
}
