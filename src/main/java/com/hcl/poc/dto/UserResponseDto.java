package com.hcl.poc.dto;

import java.util.List;
import java.util.UUID;

import com.hcl.poc.model.Users.USER_STATUS;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDto {
	private UUID id;
	
	private String applicantName;
	
	private String nricNo;
	
	private String registeredAddress;
	
	private String mailingAddress;
	
	private String contactNo;
	
	private USER_STATUS userStatus;
	
	private List<VehicleResponseDto> vehicleList;
 }
