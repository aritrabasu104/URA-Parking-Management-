package com.hcl.poc.error.custom;

import java.util.UUID;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6408501688969222766L;

	public UserNotFoundException(UUID userId) {
		super("User not found for id "+userId);
	}
}
