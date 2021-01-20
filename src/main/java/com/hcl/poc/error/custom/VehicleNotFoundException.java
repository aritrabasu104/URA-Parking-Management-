package com.hcl.poc.error.custom;

import java.util.UUID;

public class VehicleNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1482696192073735880L;

	public VehicleNotFoundException(UUID vehicleId) {
		super("Vehicle not found for id "+vehicleId);
	}
}
