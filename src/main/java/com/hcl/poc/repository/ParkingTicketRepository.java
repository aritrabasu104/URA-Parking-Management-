package com.hcl.poc.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.hcl.poc.model.ParkingTicket;

public interface ParkingTicketRepository extends CrudRepository<ParkingTicket, UUID> {

}
