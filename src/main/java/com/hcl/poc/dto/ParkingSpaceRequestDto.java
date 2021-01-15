package com.hcl.poc.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingSpaceRequestDto {

	@NotBlank
	private String location;
	
	@NotBlank
	private String timing;
	
	private List<ParkingSlotAvailabilityResponseDto> parkingSlotAvailability;
	
	private List<ParkingSlotFeeResponseDto> parkingSlotFee;
		
	
}
