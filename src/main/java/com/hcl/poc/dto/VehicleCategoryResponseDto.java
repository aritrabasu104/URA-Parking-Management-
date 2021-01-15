package com.hcl.poc.dto;

import java.util.UUID;

import com.hcl.poc.model.VehicleCategory.VEHICLE_SIZE;
import com.hcl.poc.model.VehicleCategory.VEHICLE_TYPE;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehicleCategoryResponseDto {

	private UUID id;
	private VEHICLE_SIZE vehicleSize;
	private VEHICLE_TYPE vehicleType;
	
}
