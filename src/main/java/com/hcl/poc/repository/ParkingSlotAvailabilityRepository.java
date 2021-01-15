package com.hcl.poc.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.poc.model.ParkingSlotAvailability;

public interface ParkingSlotAvailabilityRepository extends CrudRepository<ParkingSlotAvailability, UUID> {

}
