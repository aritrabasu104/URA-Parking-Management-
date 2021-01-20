package com.hcl.poc.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.hcl.poc.model.VehicleCategory;
import com.hcl.poc.model.VehicleCategory.VEHICLE_SIZE;
import com.hcl.poc.model.VehicleCategory.VEHICLE_TYPE;
import com.hcl.poc.repository.ParkingSlotAvailabilityRepository;
import com.hcl.poc.repository.ParkingSlotFeeRepository;
import com.hcl.poc.repository.ParkingSpaceRepository;
import com.hcl.poc.repository.ParkingTicketRepository;
import com.hcl.poc.repository.UserRepository;
import com.hcl.poc.repository.VehicleCategoryRepository;
import com.hcl.poc.repository.VehicleRepository;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	private ParkingSlotFeeRepository parkingSlotFeeRepository;

	@Mock
	private ParkingSlotAvailabilityRepository parkingSlotAvailabilityRepository;

	@Mock
	private ParkingSpaceRepository parkingSpaceRepository;

	@Mock
	private ParkingTicketRepository parkingTicketRepository;

	@Mock
	private VehicleRepository vehicleRepository;

	@Mock
	private VehicleCategoryRepository vehicleCategoryRepository;

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;
	
	private List<VehicleCategory> vehicleCategories;
	
	@Before
	public void init() {
		
		vehicleCategories = new ArrayList<>();
		VehicleCategory vehicleCategory = new VehicleCategory();
		vehicleCategory.setId(UUID.randomUUID());
		vehicleCategory.setVehicleSize(VEHICLE_SIZE.LIGHT);
		vehicleCategory.setVehicleType(VEHICLE_TYPE.PRIVATE);
		vehicleCategories.add(vehicleCategory);
				
	}
	@Test
	public void shouldgetVehicleCategories() {
		given(vehicleCategoryRepository.findAll()).willReturn(vehicleCategories);

		List<VehicleCategory> result = userService.getVehicleCategories();
		assertEquals(vehicleCategories, result);
		
		verify(vehicleCategoryRepository, times(1)).findAll();
	}
}
