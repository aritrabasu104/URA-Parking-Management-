package com.hcl.poc.service;

import com.hcl.poc.model.AppUser;
import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.Vehicle;
import com.hcl.poc.model.VehicleCategory;

public interface AdminService {
	VehicleCategory addVehicleCategory(VehicleCategory vehicleCategory);
	ParkingSlotAvailability addParkingSlotAvailability(ParkingSlotAvailability parkingSlotAvailability);
	ParkingSlotFee addParkingSlotFee(ParkingSlotFee parkingSlotFee);
	ParkingSpace addParkingSpace(ParkingSpace parkingSpace);
	AppUser addUser(AppUser user);
	Vehicle addVehicles(Vehicle vehicle);
	
	void removeVehicleCategory(VehicleCategory vehicleCategory);
	void removeParkingSlotAvailability(ParkingSlotAvailability parkingSlotAvailability);
	void removeParkingSlotFee(ParkingSlotFee parkingSlotFee);
	void removeParkingSpace(ParkingSpace parkingSpace);
	
	
}
