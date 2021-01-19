package com.hcl.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.hcl.poc.model.VehicleCategory.VEHICLE_SIZE;
import com.hcl.poc.model.VehicleCategory.VEHICLE_TYPE;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
public class Vehicle {
	
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;
	
	private String vehicleNo;
	
	private String uenNumber;
	
	private String inVehicleUnitLabel;
	
	private String companyName;
	
	private VEHICLE_SIZE vehicleSize;
	
	private VEHICLE_TYPE vehiclType;
}
