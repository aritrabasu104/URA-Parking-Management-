package com.hcl.poc.dto;

import javax.validation.constraints.NotNull;

import com.hcl.poc.model.VehicleCategory.VEHICLE_SIZE;
import com.hcl.poc.model.VehicleCategory.VEHICLE_TYPE;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehicleCategoryRequestDto {

	@NotNull
	private VEHICLE_SIZE vehicleSize;
	
	@NotNull
	private VEHICLE_TYPE vehicleType;
	
}
