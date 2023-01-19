package com.desidukaan.service;

import com.desidukaan.exception.LoginException;
import com.desidukaan.model.LoginDTO;

public interface LoginService {
	
	public String login(LoginDTO dto) throws LoginException;
	public String logout(String key) throws LoginException;

}
