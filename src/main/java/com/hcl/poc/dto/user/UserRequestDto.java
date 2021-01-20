package com.hcl.poc.dto.user;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.hcl.poc.dto.vehicle.VehicleRequestDto;
import com.hcl.poc.model.AppUser.UserStaus;

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
	
	@Email
	private String emailId;
	
	@NotBlank
	//@Pattern()
	private String contactNo;
	
	@NotNull
	private UserStaus userStatus;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
	private List<VehicleRequestDto> vehicleList;

	public UserRequestDto() {

	}
}
