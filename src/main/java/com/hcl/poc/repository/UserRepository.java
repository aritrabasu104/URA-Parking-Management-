package com.hcl.poc.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.poc.model.AppUser;

public interface UserRepository extends CrudRepository<AppUser, UUID> {
	
	@Query("SELECT u FROM Users u where u.userName = :username AND u.password = :password")
    public Optional<AppUser> validateLoginUser(@Param("username") String username, @Param("password") String password);
     
}
