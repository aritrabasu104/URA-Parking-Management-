package com.hcl.poc.dto.parking;

import java.time.Month;
import java.time.Year;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.hcl.poc.dto.user.UserIdDto;
import com.hcl.poc.dto.vehicle.VehicleIdDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ParkingTicketRequestDto {

	@NotNull
	private UserIdDto user;
	
	@NotNull
	private VehicleIdDto vehicle;
	
	@NotNull
	private ParkingSpaceIdDto parkingSpace;

	@NotNull
	private Month month;
	
	@NotNull
	@Min(2020)
	private Integer year;
	
}
