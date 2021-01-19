package com.hcl.poc.service;

import com.hcl.poc.dto.login.Login;
import com.hcl.poc.dto.login.LoginResponse;

public interface LoginService {
	LoginResponse doLogin(Login login);
}
