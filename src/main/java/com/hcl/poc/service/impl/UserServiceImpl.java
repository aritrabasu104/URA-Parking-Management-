package com.hcl.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.poc.model.AppUser;
import com.hcl.poc.repository.UserRepository;
import com.hcl.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public AppUser createUser() {
		AppUser user = new AppUser();
		return userRepository.save(user);
	}

}
