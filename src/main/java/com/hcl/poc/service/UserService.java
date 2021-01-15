package com.hcl.poc.service;

import java.util.List;

import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.VehicleCategory;

public interface UserService {
	List<VehicleCategory> getVehicleCategories();
	List<ParkingSlotAvailability> getParkingSlotAvailabilities();
	List<ParkingSlotFee> getParkingSlotFees();
	List<ParkingSpace> getParkingSpaces();
}
