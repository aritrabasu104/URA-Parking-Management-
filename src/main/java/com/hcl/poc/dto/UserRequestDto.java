package com.hcl.poc.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.hcl.poc.model.Users.USER_STATUS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {
	@NotNull
	private String applicantName;
	
	@NotNull
	private String nricNo;
	
	@NotNull
	private String registeredAddress;
	
	@NotNull
	private String mailingAddress;
	
	@NotNull
	//@Pattern()
	private String contactNo;
	
	@NotNull
	private USER_STATUS userStatus;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	private List<VehicleRequestDto> vehicleList;

	public UserRequestDto() {

	}
}
