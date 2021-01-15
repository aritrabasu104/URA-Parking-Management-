package com.hcl.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ParkingSlotFee {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;
	
	@OneToOne
	private VehicleCategory vehicleCategory;
	
	private Integer count;
}
