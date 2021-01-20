package com.hcl.poc.dto.parking;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.hcl.poc.dto.vehicle.VehicleCategoryResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSlotFeeRequestDto {
	
	@NotNull
	private VehicleCategoryResponseDto vehicleCategory;
	
	@NotNull
	@Min(1)
	private Double cost;
}
