package com.hcl.poc.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.poc.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, UUID>{

}
