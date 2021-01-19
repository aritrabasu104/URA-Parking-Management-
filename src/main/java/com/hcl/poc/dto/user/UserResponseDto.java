package com.hcl.poc.dto.user;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Email;

import com.hcl.poc.dto.vehicle.VehicleResponseDto;
import com.hcl.poc.model.AppUser.UserStaus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDto {
	private UUID id;
	
	private String applicantName;
	
	private String nricNo;
	
	private String registeredAddress;
	
	private String mailingAddress;
	
	@Email
	private String emailId;
	
	private String contactNo;
	
	private UserStaus userStatus;
	
	private List<VehicleResponseDto> vehicleList;
 }
