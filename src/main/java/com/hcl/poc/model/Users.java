package com.hcl.poc.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	private USER_STATUS userStatus;
	
	private String userName;
	
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Vehicle> vehicleList;
	
	public enum USER_STATUS {
		PENDING, CLEAN, ISSUE_EXIST
	}
}
