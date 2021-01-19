package com.hcl.poc.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

import com.hcl.poc.dto.ParkingSlotFeeResponseDto;
import com.hcl.poc.dto.ParkingSpaceResponseDto;
import com.hcl.poc.dto.UserResponseDto;
import com.hcl.poc.dto.VehicleCategoryResponseDto;
import com.hcl.poc.dto.VehicleRequestDto;
import com.hcl.poc.dto.VehicleResponseDto;
import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.AppUser;
import com.hcl.poc.model.Vehicle;
import com.hcl.poc.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = CorsConfiguration.ALL)
@Validated
public class UserController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/vehicle")
	public ResponseEntity<VehicleResponseDto> addVehicle(@RequestParam(required = true) UUID userId, 
			@Valid @RequestBody VehicleRequestDto vehicleRequestDto) {
		Vehicle vehicle = modelMapper.map(vehicleRequestDto, Vehicle.class);
		return ResponseEntity.ok(modelMapper.map(userService.addVehicle(userId,vehicle)
				,VehicleResponseDto.class));
	}
	
	@GetMapping("/info")
	public ResponseEntity<UserResponseDto> getUserInfo(@RequestParam(required = true) UUID userId) {	
		return ResponseEntity.ok(modelMapper.map(userService.getUserInfo(userId), UserResponseDto.class));
	}
	
	@PutMapping("/info")
	public ResponseEntity<UserResponseDto> updateUserInfo(@Valid @RequestBody UserResponseDto userResponseDto) {
		AppUser user = modelMapper.map(userResponseDto, AppUser.class);
		return ResponseEntity.ok(modelMapper.map(userService.updateUserInfo(user), UserResponseDto.class));
	}
	
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
	
	@GetMapping("/parkingSpaces")
	public ResponseEntity<List<ParkingSpaceResponseDto>> getParkingSpaces() {
		return ResponseEntity.ok(userService.getParkingSpaces().stream().map(item->modelMapper.map(item
				,ParkingSpaceResponseDto.class)).collect(Collectors.toList()));
	}
	
	@GetMapping("/parkingSpace")
	public ResponseEntity<List<ParkingSpaceResponseDto>> getParkingSpacesByCity(@RequestParam @NotBlank String city) {
		return ResponseEntity.ok(userService.getParkingSpacesByCity(city).stream().map(item->modelMapper.map(item
				,ParkingSpaceResponseDto.class)).collect(Collectors.toList()));
	}
}
