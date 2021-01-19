package com.hcl.poc.dto.parking;

import javax.validation.constraints.NotNull;

import com.hcl.poc.dto.vehicle.VehicleCategoryResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSlotAvailabilityRequestDto {

	@NotNull
	private VehicleCategoryResponseDto vehicleCategory;
	
	@NotNull
	private Integer count;
}
