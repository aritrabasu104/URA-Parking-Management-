package com.hcl.poc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.Users;
import com.hcl.poc.model.Vehicle;
import com.hcl.poc.model.VehicleCategory;
import com.hcl.poc.repository.ParkingSlotAvailabilityRepository;
import com.hcl.poc.repository.ParkingSlotFeeRepository;
import com.hcl.poc.repository.ParkingSpaceRepository;
import com.hcl.poc.repository.UserRepository;
import com.hcl.poc.repository.VehicleCategoryRepository;
import com.hcl.poc.repository.VehicleRepository;
import com.hcl.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private ParkingSlotFeeRepository parkingSlotFeeRepository;
	
	@Autowired
	private ParkingSlotAvailabilityRepository parkingSlotAvailabilityRepository;
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleCategoryRepository vehicleCategoryRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<VehicleCategory> getVehicleCategories() {
		List<VehicleCategory> result = new ArrayList<>();
		 vehicleCategoryRepository.findAll().forEach(result::add);
		 return result;
	}

	@Override
	public List<ParkingSlotAvailability> getParkingSlotAvailabilities() {
		List<ParkingSlotAvailability> result = new ArrayList<>();
		parkingSlotAvailabilityRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<ParkingSlotFee> getParkingSlotFees() {
		List<ParkingSlotFee> result = new ArrayList<>();
		parkingSlotFeeRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<ParkingSpace> getParkingSpaces() {
		List<ParkingSpace> result = new ArrayList<>();
		parkingSpaceRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<ParkingSpace> getParkingSpacesByCity(String city) {
		return parkingSpaceRepository.findAllByCityIgnoreCase(city);
	}
	
	@Override
	public Users getUserInfo(String userId) {
		Optional<Users> user =  userRepository.findById(UUID.fromString(userId));
		
		return user.isPresent() ? user.get() : user.orElse(new Users());
	}

	@Override
	public Vehicle addVehicle(UUID userId, Vehicle vehicle) {
		vehicle = vehicleRepository.save(vehicle);
		Users user = userRepository.findById(userId).get();
		List<Vehicle> userVehicles = user.getVehicleList();
		userVehicles.add(vehicle);
		user.setVehicleList(userVehicles);
		return vehicle;
	}
}
