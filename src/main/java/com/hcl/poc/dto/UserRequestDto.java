package com.hcl.poc.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.hcl.poc.model.AppUser.USER_STATUS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {
	@NotBlank
	private String applicantName;
	
	@NotBlank
	private String nricNo;
	
	@NotBlank
	private String registeredAddress;
	
	@NotBlank
	private String mailingAddress;
	
	@NotBlank
	//@Pattern()
	private String contactNo;
	
	@NotNull
	private USER_STATUS userStatus;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
	private List<VehicleRequestDto> vehicleList;

	public UserRequestDto() {

	}
}
