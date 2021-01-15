package com.hcl.poc.dto;

import javax.validation.constraints.NotBlank;

import com.hcl.poc.model.VehicleCategory.VEHICLE_SIZE;
import com.hcl.poc.model.VehicleCategory.VEHICLE_TYPE;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehicleCategoryRequestDto {

	@NotBlank
	private VEHICLE_SIZE vehicleSize;
	
	@NotBlank
	private VEHICLE_TYPE vehicleType;
	
}
