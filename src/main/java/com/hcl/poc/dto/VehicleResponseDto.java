package com.hcl.poc.dto;

import java.util.UUID;

import com.hcl.poc.model.VehicleCategory.VEHICLE_SIZE;
import com.hcl.poc.model.VehicleCategory.VEHICLE_TYPE;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehicleResponseDto {
	private UUID id;
	
	private String vehicleNo;
	
	private String uenNumber;
	
	private String inVehicleUnitLabel;
	
	private String companyName;
	
	private VEHICLE_SIZE vehicleSize;
	
	private VEHICLE_TYPE vehiclType;
}
