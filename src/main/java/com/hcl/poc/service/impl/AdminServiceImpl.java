package com.hcl.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.VehicleCategory;
import com.hcl.poc.repository.ParkingSlotAvailabilityRepository;
import com.hcl.poc.repository.ParkingSlotFeeRepository;
import com.hcl.poc.repository.ParkingSpaceRepository;
import com.hcl.poc.repository.VehicleCategoryRepository;
import com.hcl.poc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ParkingSlotFeeRepository parkingSlotFeeRepository;
	
	@Autowired
	private ParkingSlotAvailabilityRepository parkingSlotAvailabilityRepository;
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;
	
	@Autowired
	private VehicleCategoryRepository vehicleCategoryRepository;
	
	@Override
	public VehicleCategory addVehicleCategory(VehicleCategory vehicleCategory) {
		return vehicleCategoryRepository.save(vehicleCategory);
	}

	@Override
	public ParkingSlotAvailability addParkingSlotAvailability(ParkingSlotAvailability parkingSlotAvailability) {
		return parkingSlotAvailabilityRepository.save(parkingSlotAvailability);
	}

	@Override
	public ParkingSlotFee addParkingSlotFee(ParkingSlotFee parkingSlotFee) {
		return parkingSlotFeeRepository.save(parkingSlotFee);
	}

	@Override
	public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) {
		return parkingSpaceRepository.save(parkingSpace);
	}

	@Override
	public void removeVehicleCategory(VehicleCategory vehicleCategory) {
		vehicleCategoryRepository.delete(vehicleCategory);
	}

	@Override
	public void removeParkingSlotAvailability(ParkingSlotAvailability parkingSlotAvailability) {
		parkingSlotAvailabilityRepository.delete(parkingSlotAvailability);
	}

	@Override
	public void removeParkingSlotFee(ParkingSlotFee parkingSlotFee) {
		parkingSlotFeeRepository.delete(parkingSlotFee);
	}

	@Override
	public void removeParkingSpace(ParkingSpace parkingSpace) {
		parkingSpaceRepository.delete(parkingSpace);
	}

}
