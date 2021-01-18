package com.hcl.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Users {
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;
	
	private String applicantName;
	
	private String nricNo;
	
	private String registeredAddress;
	
	private String mailingAddress;
	
	private String contactNo;
	
	private String userStatus;
	
	private String userName;
	
	private String password;
	
	//private List<Vehicle> vehicleList;
}
