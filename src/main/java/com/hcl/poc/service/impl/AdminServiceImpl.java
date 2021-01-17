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

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
		log.info("saving {}",vehicleCategory);
		return vehicleCategoryRepository.save(vehicleCategory);
	}

	@Override
	public ParkingSlotAvailability addParkingSlotAvailability(ParkingSlotAvailability parkingSlotAvailability) {
		log.info("saving {}",parkingSlotAvailability);
		return parkingSlotAvailabilityRepository.save(parkingSlotAvailability);
	}

	@Override
	public ParkingSlotFee addParkingSlotFee(ParkingSlotFee parkingSlotFee) {
		log.info("saving {}",parkingSlotFee);
		return parkingSlotFeeRepository.save(parkingSlotFee);
	}

	@Override
	public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) {
		log.info("saving {}",parkingSpace);
		return parkingSpaceRepository.save(parkingSpace);
	}

	@Override
	public void removeVehicleCategory(VehicleCategory vehicleCategory) {
		log.info("deleting {}",vehicleCategory);
		vehicleCategoryRepository.delete(vehicleCategory);
	}

	@Override
	public void removeParkingSlotAvailability(ParkingSlotAvailability parkingSlotAvailability) {
		log.info("deleting {}",parkingSlotAvailability);
		parkingSlotAvailabilityRepository.delete(parkingSlotAvailability);
	}

	@Override
	public void removeParkingSlotFee(ParkingSlotFee parkingSlotFee) {
		log.info("deleting {}",parkingSlotFee);
		parkingSlotFeeRepository.delete(parkingSlotFee);
	}

	@Override
	public void removeParkingSpace(ParkingSpace parkingSpace) {
		log.info("deleting {}",parkingSpace);
		parkingSpaceRepository.delete(parkingSpace);
	}

}
