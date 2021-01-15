package com.hcl.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ParkingSpace {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;

	private String location;
	
	private String timing;
	
	@OneToMany
	private ParkingSlotAvailability parkingSlotAvailability;
	
	@OneToMany
	private ParkingSlotFee parkingSlotFee;
		
	
}
