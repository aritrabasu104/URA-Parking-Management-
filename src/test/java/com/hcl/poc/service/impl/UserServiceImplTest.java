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

import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
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
	private List<ParkingSlotAvailability> parkingSlotAvailabilities;
	private List<ParkingSlotFee> parkingSlotFees;
	private List<ParkingSpace> parkingSpaces;
	
	@Before
	public void init() {
		
		vehicleCategories = new ArrayList<>();
		VehicleCategory vehicleCategory = new VehicleCategory();
		vehicleCategory.setId(UUID.randomUUID());
		vehicleCategory.setVehicleSize(VEHICLE_SIZE.LIGHT);
		vehicleCategory.setVehicleType(VEHICLE_TYPE.PRIVATE);
		vehicleCategories = List.of(vehicleCategory);
		
		ParkingSlotAvailability parkingSlotAvailability = new ParkingSlotAvailability();
		parkingSlotAvailability.setId(UUID.randomUUID());
		parkingSlotAvailability.setCount(10);
		parkingSlotAvailability.setVehicleCategory(vehicleCategory);
		parkingSlotAvailabilities = List.of(parkingSlotAvailability);
		
		ParkingSlotFee parkingSlotFee = new ParkingSlotFee();
		parkingSlotFee.setId(UUID.randomUUID());
		parkingSlotFee.setCost(240d);
		parkingSlotFee.setVehicleCategory(vehicleCategory);
		parkingSlotFees = List.of(parkingSlotFee);
		
		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setCity("london");
		parkingSpace.setId(UUID.randomUUID());
		parkingSpace.setTiming("7 am to 7 pm");
		parkingSpace.setParkingSlotAvailability(parkingSlotAvailabilities);
		parkingSpace.setParkingSlotFee(parkingSlotFees);
		parkingSpace.setLocation("The London Eye");
		parkingSpaces = List.of(parkingSpace);
	}
	@Test
	public void shouldGetVehicleCategories() {
		given(vehicleCategoryRepository.findAll()).willReturn(vehicleCategories);

		List<VehicleCategory> result = userService.getVehicleCategories();
		assertEquals(vehicleCategories, result);
		
		verify(vehicleCategoryRepository, times(1)).findAll();
	}
	
	@Test
	public void shouldGetParkingSlotAvailabilities() {
		given(parkingSlotAvailabilityRepository.findAll()).willReturn(parkingSlotAvailabilities);

		List<ParkingSlotAvailability> result = userService.getParkingSlotAvailabilities();
		assertEquals(parkingSlotAvailabilities, result);
		
		verify(parkingSlotAvailabilityRepository, times(1)).findAll();
	}
	
	@Test
	public void shouldGetParkingSlotFees() {
		given(parkingSlotFeeRepository.findAll()).willReturn(parkingSlotFees);

		List<ParkingSlotFee> result = userService.getParkingSlotFees();
		assertEquals(parkingSlotFees, result);
		
		verify(parkingSlotFeeRepository, times(1)).findAll();
	}
	
	@Test
	public void shouldGetParkingSpaces() {
		given(parkingSpaceRepository.findAll()).willReturn(parkingSpaces);

		List<ParkingSpace> result = userService.getParkingSpaces();
		assertEquals(parkingSpaces, result);
		
		verify(parkingSpaceRepository, times(1)).findAll();
	}
	
	
	
}
