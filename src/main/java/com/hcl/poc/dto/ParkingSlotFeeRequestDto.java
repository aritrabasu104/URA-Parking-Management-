package com.hcl.poc.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSlotFeeRequestDto {
	
	@NotNull
	private VehicleCategoryResponseDto vehicleCategory;
	
	@NotNull
	@Min(1)
	private Integer count;
}
