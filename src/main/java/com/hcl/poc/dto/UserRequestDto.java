package com.hcl.poc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {
	private String applicantName;
	
	private String nricNo;
	
	private String registeredAddress;
	
	private String mailingAddress;
	
	private String contactNo;
	
	private String userStatus;
	
	private String userName;
	
	private String password;
	
	//private List<Vehicle> vehicleList;

	public UserRequestDto() {

	}
}
