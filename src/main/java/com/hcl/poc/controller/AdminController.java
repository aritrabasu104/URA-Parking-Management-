package com.hcl.poc.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

import com.hcl.poc.dto.parking.ParkingSlotAvailabilityRequestDto;
import com.hcl.poc.dto.parking.ParkingSlotAvailabilityResponseDto;
import com.hcl.poc.dto.parking.ParkingSlotFeeRequestDto;
import com.hcl.poc.dto.parking.ParkingSlotFeeResponseDto;
import com.hcl.poc.dto.parking.ParkingSpaceRequestDto;
import com.hcl.poc.dto.parking.ParkingSpaceResponseDto;
import com.hcl.poc.dto.user.UserRequestDto;
import com.hcl.poc.dto.user.UserResponseDto;
import com.hcl.poc.dto.vehicle.VehicleCategoryRequestDto;
import com.hcl.poc.dto.vehicle.VehicleCategoryResponseDto;
import com.hcl.poc.model.AppUser;
import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.VehicleCategory;
import com.hcl.poc.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = CorsConfiguration.ALL)
public class AdminController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/vehicleCategory")
	public ResponseEntity<VehicleCategoryResponseDto> addVehicleCategory(@Valid @RequestBody VehicleCategoryRequestDto vehicleCategoryRequestDto) {
		VehicleCategory vehicleCategory = modelMapper.map(vehicleCategoryRequestDto, VehicleCategory.class);
		return ResponseEntity.ok(modelMapper.map(adminService.addVehicleCategory(vehicleCategory)
				,VehicleCategoryResponseDto.class));
	}
	
	@PostMapping("/parkingSlotFee")
	public ResponseEntity<ParkingSlotFeeResponseDto> addParkingFee(@Valid @RequestBody ParkingSlotFeeRequestDto parkingSlotFeeRequestDto) {
		ParkingSlotFee parkingSlotFee = modelMapper.map(parkingSlotFeeRequestDto, ParkingSlotFee.class);
		return ResponseEntity.ok(modelMapper.map(adminService.addParkingSlotFee(parkingSlotFee)
				,ParkingSlotFeeResponseDto.class));
	}
	
	@PostMapping("/parkingSlotAvailability")
	public ResponseEntity<ParkingSlotAvailabilityResponseDto> addParkingAvilability(@Valid @RequestBody ParkingSlotAvailabilityRequestDto parkingSlotAvailabilityRequestDto) {
		ParkingSlotAvailability parkingSlotAvailability = modelMapper.map(parkingSlotAvailabilityRequestDto, ParkingSlotAvailability.class);
		return ResponseEntity.ok(modelMapper.map(adminService.addParkingSlotAvailability(parkingSlotAvailability)
				,ParkingSlotAvailabilityResponseDto.class));
	}
	
	@PostMapping("/parkingSpace")
	public ResponseEntity<ParkingSpaceResponseDto> addParkingSpace(@Valid @RequestBody ParkingSpaceRequestDto parkingSpaceRequestDto) {
		ParkingSpace parkingSpace = modelMapper.map(parkingSpaceRequestDto, ParkingSpace.class);
		return ResponseEntity.ok(modelMapper.map(adminService.addParkingSpace(parkingSpace)
				,ParkingSpaceResponseDto.class));
	}
	
	@PostMapping("/create/user")
	public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		AppUser user = modelMapper.map(userRequestDto, AppUser.class);
		
		return ResponseEntity.ok(modelMapper.map(adminService.addUser(user), UserResponseDto.class));
	}
}
