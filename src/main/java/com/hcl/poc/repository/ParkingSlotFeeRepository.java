package com.hcl.poc.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.poc.model.ParkingSlotFee;

public interface ParkingSlotFeeRepository extends CrudRepository<ParkingSlotFee, UUID> {

}
