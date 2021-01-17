package com.hcl.poc.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.poc.model.ParkingSpace;

public interface ParkingSpaceRepository extends CrudRepository<ParkingSpace, UUID> {

	List<ParkingSpace> findAllByCity(String city);
}
