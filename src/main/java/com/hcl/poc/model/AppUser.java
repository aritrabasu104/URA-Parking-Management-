package com.hcl.poc.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AppUser {
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;
	
	private String applicantName;
	
	private String nricNo;
	
	private String registeredAddress;
	
	private String mailingAddress;
	
	@Column(unique = true)
	private String contactNo;
	
	@Email
	private String emailId;
	
	private UserStaus userStatus;
	
	private String userName;
	
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Vehicle> vehicleList;
	
	public enum UserStaus {
		PENDING, CLEAN, ISSUE_EXIST
	}
}
