package com.hcl.poc.service;

import com.hcl.poc.dto.Login;
import com.hcl.poc.dto.LoginResponse;

public interface LoginService {
	LoginResponse doLogin(Login login);
}
