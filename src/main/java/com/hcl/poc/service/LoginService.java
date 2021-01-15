package com.hcl.poc.service;

import com.hcl.poc.model.Login;
import com.hcl.poc.model.LoginResponse;

public interface LoginService {
	LoginResponse doLogin(Login login);
}
