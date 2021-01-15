package com.hcl.poc.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSpaceResponseDto {

	private UUID id; 
	
	private String location;
	
	private String timing;
	
	private List<ParkingSlotAvailabilityResponseDto> parkingSlotAvailability;
	
	private List<ParkingSlotFeeResponseDto> parkingSlotFee;
		
	
}
