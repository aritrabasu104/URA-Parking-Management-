package com.hcl.poc.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.hcl.poc.repository.ParkingSlotAvailabilityRepository;
import com.hcl.poc.repository.ParkingSlotFeeRepository;
import com.hcl.poc.repository.ParkingSpaceRepository;
import com.hcl.poc.repository.ParkingTicketRepository;
import com.hcl.poc.repository.UserRepository;
import com.hcl.poc.repository.VehicleCategoryRepository;
import com.hcl.poc.repository.VehicleRepository;
import com.hcl.poc.service.impl.UserServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

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
	
	
}
