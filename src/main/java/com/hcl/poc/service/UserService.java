package com.hcl.poc.service;

import java.util.List;
import java.util.UUID;

import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.ParkingTicket;
import com.hcl.poc.error.custom.ParkingSpaceNotFoundException;
import com.hcl.poc.error.custom.UserNotFoundException;
import com.hcl.poc.error.custom.VehicleNotFoundException;
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
	Vehicle addVehicle(UUID userId, Vehicle vehicle) throws UserNotFoundException;
	AppUser updateUserInfo(AppUser user);
	Vehicle updateVehicle(Vehicle vehicle);
	ParkingTicket requestParkingTicket(ParkingTicket parkingTicket) throws UserNotFoundException, VehicleNotFoundException, ParkingSpaceNotFoundException;
}
