package com.hcl.poc.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.poc.model.VehicleCategory;

public interface VehicleCategoryRepository extends CrudRepository<VehicleCategory, UUID> {

}
