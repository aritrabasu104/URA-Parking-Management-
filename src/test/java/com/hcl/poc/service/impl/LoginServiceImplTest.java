package com.hcl.poc.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.poc.dto.Login;
import com.hcl.poc.dto.LoginResponse;
import com.hcl.poc.model.AppUser;
import com.hcl.poc.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginServiceImplTest {

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	@Mock
	UserRepository userRepository;

	@Test
	public void test() {
		Login login = getLogin();
		when(userRepository.validateLoginUser(login.getUserName(), login.getPassword())).thenReturn(getAppUser());

		LoginResponse response = loginServiceImpl.doLogin(getLogin());

		assertEquals("TEST", response.getUserName());
	}

	public Login getLogin() {
		Login login = new Login();
		login.setUserName("Test");
		login.setPassword("password");

		return login;
	}

	public Optional<AppUser> getAppUser() {
		AppUser appUser = new AppUser();
		appUser.setApplicantName("TEST");
		appUser.setContactNo("23245222");
		appUser.setId(UUID.randomUUID());

		return Optional.of(appUser);
	}
}
