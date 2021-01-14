package com.hcl.poc.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.poc.model.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {

}
