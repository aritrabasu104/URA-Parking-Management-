package com.hcl.poc.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.poc.model.Users;

public interface UserRepository extends CrudRepository<Users, UUID> {
	
	@Query("SELECT u FROM Users u where u.userName = :username AND u.password = :password")
    public Optional<Users> validateLoginUser(@Param("username") String username, @Param("password") String password);
     
}
