package com.hcl.poc.model;

import java.time.Month;
import java.time.Year;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ParkingTicket {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;
	
	@NotNull
	@ManyToOne
	private AppUser user;
	
	@NotNull
	@ManyToOne
	private Vehicle vehicle;
	
	@NotNull
	@ManyToOne
	private ParkingSpace parkingSpace;

	@NotNull
	private Month month;
	
	@NotNull
	@Min(2020)
	private Integer year;
	
	private TicketStatus status;
	
	private String detail;
	
	public enum TicketStatus{
		APPROVED,PENDING,REJECTED
	}
	
}
