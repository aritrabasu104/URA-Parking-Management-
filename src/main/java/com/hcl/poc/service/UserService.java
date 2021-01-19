package com.hcl.poc.service;

import java.util.List;
import java.util.UUID;

import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.AppUser;
import com.hcl.poc.model.Vehicle;
import com.hcl.poc.model.VehicleCategory;

public interface UserService {
	List<VehicleCategory> getVehicleCategories();
	List<ParkingSlotAvailability> getParkingSlotAvailabilities();
	List<ParkingSlotFee> getParkingSlotFees();
	List<ParkingSpace> getParkingSpaces();
	List<ParkingSpace> getParkingSpacesByCity(String city);
	AppUser getUserInfo(UUID userId);
	Vehicle addVehicle(UUID userId, Vehicle vehicle);
	AppUser updateUserInfo(AppUser user);
}
