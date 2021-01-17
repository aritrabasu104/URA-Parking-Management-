package com.hcl.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ParkingSlotAvailability {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;
	
	@OneToOne
	private VehicleCategory vehicleCategory;
	
	private Integer count;
}
