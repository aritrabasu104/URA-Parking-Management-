package com.hcl.poc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = CorsConfiguration.ALL)
public class AdminController {

	@GetMapping("/vehicleCategory")
	public ResponseEntity<?> addVehicleCategory() {
		return ResponseEntity.ok().build();
	}
	
}
