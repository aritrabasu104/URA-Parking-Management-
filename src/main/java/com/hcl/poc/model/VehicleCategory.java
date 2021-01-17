package com.hcl.poc.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VehicleCategory {

	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID id;

	private VEHICLE_SIZE vehicleSize;
	private VEHICLE_TYPE vehicleType;
	
	public enum VEHICLE_TYPE{
		PRIVATE, COMMERCIAL
	}
	public enum VEHICLE_SIZE{
		LIGHT, MEDIUM , HEAVY
	}
}
