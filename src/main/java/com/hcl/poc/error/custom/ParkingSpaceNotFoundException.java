package com.hcl.poc.error.custom;

import java.util.UUID;

public class ParkingSpaceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6408501688969222766L;

	public ParkingSpaceNotFoundException(UUID parkingSpaceId) {
		super("Parking Space not found for id "+parkingSpaceId);
	}
}
