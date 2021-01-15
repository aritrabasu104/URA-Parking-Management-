package com.hcl.poc.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSlotFeeResponseDto {

	private UUID id;
	
	private VehicleCategoryResponseDto vehicleCategory;
	
	private Integer count;
}
