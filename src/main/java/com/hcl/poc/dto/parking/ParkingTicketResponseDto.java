package com.hcl.poc.dto.parking;

import java.time.Month;
import java.time.Year;
import java.util.UUID;

import com.hcl.poc.dto.user.UserIdDto;
import com.hcl.poc.dto.vehicle.VehicleIdDto;
import com.hcl.poc.model.ParkingTicket.TicketStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParkingTicketResponseDto {

	private UUID id;

	private UserIdDto user;

	private VehicleIdDto vehicle;

	private ParkingSpaceIdDto parkingSpace;

	private Month month;

	private Integer year;

	private TicketStatus status;

	private String detail;

}
