package com.hcl.poc.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSlotAvailabilityRequestDto {

	@NotNull
	private VehicleCategoryResponseDto vehicleCategory;
	
	@NotNull
	private Integer count;
}
