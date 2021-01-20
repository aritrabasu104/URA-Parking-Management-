package com.hcl.poc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hcl.poc.model.ParkingSlotAvailability;
import com.hcl.poc.model.ParkingSlotFee;
import com.hcl.poc.model.ParkingSpace;
import com.hcl.poc.model.ParkingTicket;
import com.hcl.poc.model.ParkingTicket.TicketStatus;
import com.hcl.poc.model.AppUser;
import com.hcl.poc.model.AppUser.UserStaus;
import com.hcl.poc.model.Vehicle;
import com.hcl.poc.model.VehicleCategory;
import com.hcl.poc.repository.ParkingSlotAvailabilityRepository;
import com.hcl.poc.repository.ParkingSlotFeeRepository;
import com.hcl.poc.repository.ParkingSpaceRepository;
import com.hcl.poc.repository.ParkingTicketRepository;
import com.hcl.poc.repository.UserRepository;
import com.hcl.poc.repository.VehicleCategoryRepository;
import com.hcl.poc.repository.VehicleRepository;
import com.hcl.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Value("${msg.userstatus.error}")
	private String USER_HAS_PENDING_ISSUES;

	@Value("${msg.userstatus.pending}")
	private String USER_ACCOUUNT_IS_PENDING;

	@Value("${msg.ticket.approved}")
	private String TICKET_IS_APPROVED;

	@Value("${msg.parking.notavilable}")
	private String PARKING_IS_NOT_AVAILABLE;

	@Autowired
	private ParkingSlotFeeRepository parkingSlotFeeRepository;

	@Autowired
	private ParkingSlotAvailabilityRepository parkingSlotAvailabilityRepository;

	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;

	@Autowired
	private ParkingTicketRepository parkingTicketRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleCategoryRepository vehicleCategoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<VehicleCategory> getVehicleCategories() {
		List<VehicleCategory> result = new ArrayList<>();
		vehicleCategoryRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<ParkingSlotAvailability> getParkingSlotAvailabilities() {
		List<ParkingSlotAvailability> result = new ArrayList<>();
		parkingSlotAvailabilityRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<ParkingSlotFee> getParkingSlotFees() {
		List<ParkingSlotFee> result = new ArrayList<>();
		parkingSlotFeeRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<ParkingSpace> getParkingSpaces() {
		List<ParkingSpace> result = new ArrayList<>();
		parkingSpaceRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public List<ParkingSpace> getParkingSpacesByCity(String city) {
		return parkingSpaceRepository.findAllByCityContainingIgnoreCase(city);
	}

	@Override
	public AppUser getUserInfo(UUID userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public Vehicle addVehicle(UUID userId, Vehicle vehicle) {
		vehicle = vehicleRepository.save(vehicle);
		AppUser user = userRepository.findById(userId).get();
		List<Vehicle> userVehicles = user.getVehicleList();
		userVehicles.add(vehicle);
		user.setVehicleList(userVehicles);
		return vehicle;
	}

	@Override
	public AppUser updateUserInfo(AppUser user) {
		AppUser currentUser = userRepository.findById(user.getId()).get();
		currentUser.setEmailId(user.getEmailId());
		currentUser.setContactNo(user.getContactNo());
		currentUser.setMailingAddress(user.getMailingAddress());
		currentUser.setRegisteredAddress(user.getRegisteredAddress());
		return userRepository.save(currentUser);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public ParkingTicket requestParkingTicket(ParkingTicket parkingTicket) {
		AppUser user = userRepository.findById(parkingTicket.getUser().getId()).get();
		if(user.getUserStatus().equals(UserStaus.ISSUE_EXIST)) {
			parkingTicket.setStatus(TicketStatus.REJECTED);
			parkingTicket.setDetail(USER_HAS_PENDING_ISSUES);
		}else if(user.getUserStatus().equals(UserStaus.PENDING)) {
			parkingTicket.setStatus(TicketStatus.PENDING);
			parkingTicket.setDetail(USER_ACCOUUNT_IS_PENDING);
		}else {
			Vehicle vehicle = vehicleRepository.findById(parkingTicket.getVehicle().getId()).get();
			ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingTicket.getParkingSpace().getId()).get();
			boolean shouldAllot = parkingSpace.getParkingSlotAvailability().stream().anyMatch(item ->{
				return item.getVehicleCategory().getVehicleSize().equals(vehicle.getVehicleSize())
						&& item.getVehicleCategory().getVehicleType().equals(vehicle.getVehiclType())
						&& item.getCount()>0;
			});
			if(shouldAllot) {
				parkingTicket.setStatus(TicketStatus.APPROVED);
				parkingTicket.setDetail(TICKET_IS_APPROVED);
			}else {
				parkingTicket.setStatus(TicketStatus.REJECTED);
				parkingTicket.setDetail(PARKING_IS_NOT_AVAILABLE);
			}
		}
		return parkingTicketRepository.save(parkingTicket);
}}
