package com.hcl.poc.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.poc.model.AppUser;
import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.Vehicle;
import com.hcl.poc.model.VehicleCategory;
import com.hcl.poc.model.VehicleCategory.VEHICLE_SIZE;
import com.hcl.poc.model.VehicleCategory.VEHICLE_TYPE;
import com.hcl.poc.repository.ParkingSlotAvailabilityRepository;
import com.hcl.poc.repository.ParkingSlotFeeRepository;
import com.hcl.poc.repository.ParkingSpaceRepository;
import com.hcl.poc.repository.UserRepository;
import com.hcl.poc.repository.VehicleCategoryRepository;
import com.hcl.poc.repository.VehicleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminServiceImplTest {
	@InjectMocks
	private AdminServiceImpl  adminService;
	
	@Mock
	private ParkingSlotFeeRepository parkingSlotFeeRepository;
	
	@Mock
	private ParkingSlotAvailabilityRepository parkingSlotAvailabilityRepository;
	
	@Mock
	private ParkingSpaceRepository parkingSpaceRepository;
	
	@Mock
	private VehicleCategoryRepository vehicleCategoryRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private VehicleRepository vehicleRepository;
	
	
	AppUser appUser;
	Vehicle vehicle;
	ParkingSpace parkingSpace;
	ParkingSlotFee parkingSlotFee;
	VehicleCategory vehicleCategory;
	ParkingSlotAvailability parkingSlotAvailability;
	
	
	@Before
	public void init() {
		appUser = new AppUser();
		appUser.setApplicantName("ABC");
		appUser.setContactNo("213414141");
		
		vehicle = new Vehicle();
		vehicle.setCompanyName("Test");
		vehicle.setId(UUID.randomUUID());
		vehicle.setInVehicleUnitLabel("Test");
		vehicle.setUenNumber("Test");
		vehicle.setVehicleNo("Test");
		vehicle.setVehicleSize(VEHICLE_SIZE.LIGHT);
		vehicle.setVehiclType(VEHICLE_TYPE.PRIVATE);
		
		vehicleCategory = new VehicleCategory();
		vehicleCategory.setId(UUID.randomUUID());
		vehicleCategory.setVehicleSize(VEHICLE_SIZE.HEAVY);
		vehicleCategory.setVehicleType(VEHICLE_TYPE.PRIVATE);
		
		parkingSlotAvailability = new ParkingSlotAvailability();
		parkingSlotAvailability.setCount(1);
		parkingSlotAvailability.setId(UUID.randomUUID());
		parkingSlotAvailability.setVehicleCategory(vehicleCategory);
		
		List<ParkingSlotAvailability> parkingSlotAvailabilityList = new ArrayList<>();
		parkingSlotAvailabilityList.add(parkingSlotAvailability);
		
		parkingSlotFee = new ParkingSlotFee();
		parkingSlotFee.setCost(Double.valueOf("123"));
		parkingSlotFee.setId(UUID.randomUUID());
		parkingSlotFee.setVehicleCategory(vehicleCategory);
		
		List<ParkingSlotFee> parkingSlotFeeList = new ArrayList<>();
		parkingSlotFeeList.add(parkingSlotFee);
		
		parkingSpace = new ParkingSpace();
		parkingSpace.setCity("Test");
		parkingSpace.setId(UUID.randomUUID());
		parkingSpace.setLocation("Test");
		parkingSpace.setParkingSlotAvailability(parkingSlotAvailabilityList);
		parkingSpace.setParkingSlotFee(parkingSlotFeeList);
		parkingSpace.setTiming("11:00");
		
	}
	
	@Test
	public void testAddUser() {
		when(userRepository.save(appUser)).thenReturn(appUser);
		AppUser user = adminService.addUser(appUser);
		assertEquals(user.getApplicantName(), "ABC");
	}
	
	@Test
	public void testAddVehicle() {
		when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
		Vehicle response = adminService.addVehicles(vehicle);
		assertEquals(response.getInVehicleUnitLabel(), "Test");
	}
	
	@Test
	public void testAddParkingSpace() {
		when(parkingSpaceRepository.save(parkingSpace)).thenReturn(parkingSpace);
		ParkingSpace response = adminService.addParkingSpace(parkingSpace);
		assertEquals(response.getLocation(), "Test");
	}
	
	@Test
	public void testAddParkingSlotFee() {
		when(parkingSlotFeeRepository.save(parkingSlotFee)).thenReturn(parkingSlotFee);
		ParkingSlotFee response = adminService.addParkingSlotFee(parkingSlotFee);
		assertEquals(response.getCost(), Double.valueOf("123"));
	}
	
	@Test
	public void testAddParkingSlotAvailability() {
		when(parkingSlotAvailabilityRepository.save(parkingSlotAvailability)).thenReturn(parkingSlotAvailability);
		ParkingSlotAvailability response = adminService.addParkingSlotAvailability(parkingSlotAvailability);
		assertEquals(response.getCount(), Integer.valueOf(1));
	}
	
	@Test
	public void testAddVehicleCategory() {
		when(vehicleCategoryRepository.save(vehicleCategory)).thenReturn(vehicleCategory);
		VehicleCategory response = adminService.addVehicleCategory(vehicleCategory);
		assertEquals(response.getVehicleSize(), VEHICLE_SIZE.HEAVY);
	}
}
