package com.hcl.poc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

import com.hcl.poc.dto.ParkingSlotFeeResponseDto;
import com.hcl.poc.dto.ParkingSpaceResponseDto;
import com.hcl.poc.dto.VehicleCategoryResponseDto;
import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = CorsConfiguration.ALL)
public class UserController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/vehicleCategory")
	public ResponseEntity<List<VehicleCategoryResponseDto>> getVehicleCategories() {
		return ResponseEntity.ok(userService.getVehicleCategories().stream().map(item->modelMapper.map(item
				,VehicleCategoryResponseDto.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("/parkingSlotFee")
	public ResponseEntity<List<ParkingSlotFeeResponseDto>> getParkingFees() {
		return ResponseEntity.ok(userService.getParkingSlotFees().stream().map(item->modelMapper.map(item
				,ParkingSlotFeeResponseDto.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("/parkingSlotAvailability")
	public ResponseEntity<List<ParkingSlotAvailability>> getParkingAvilabilities() {
		return ResponseEntity.ok(userService.getParkingSlotAvailabilities().stream().map(item->modelMapper.map(item
				,ParkingSlotAvailability.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("/parkingSpace")
	public ResponseEntity<List<ParkingSpaceResponseDto>> getParkingSpaces() {
		return ResponseEntity.ok(userService.getParkingSpaces().stream().map(item->modelMapper.map(item
				,ParkingSpaceResponseDto.class)).collect(Collectors.toList()));
	}
	
}
