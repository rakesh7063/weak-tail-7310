package com.desidukaan.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidukaan.exception.LoginException;
import com.desidukaan.model.Admin;
import com.desidukaan.model.CurrentSession;
import com.desidukaan.model.Customer;
import com.desidukaan.model.LoginDTO;
import com.desidukaan.repository.AdminDao;
import com.desidukaan.repository.CoustomerDao;
import com.desidukaan.repository.CurrentUserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private CurrentUserDao cudao;
	
	@Autowired
	private CoustomerDao custdao;
	
	
	@Override
	public String login(LoginDTO dto) throws LoginException {
		
		// admin and Customer check
		
		Admin a = admindao.findByUsername(dto.getUsername());
		
		Customer c = custdao.findByUserName(dto.getUsername());
		
		// admin loging check
		
		if(c == null && a!=null) {
		
		Optional<CurrentSession> existAdmin = cudao.findById(a.getAdminId());
		
		if(existAdmin.isPresent()) throw new LoginException("already loggedIn");
		
		if(a.getPassword().equals(dto.getPassword())) {
			RandomString rs = new RandomString();
			String key = rs.make(6);
			CurrentSession newUser = new CurrentSession();
			
		newUser.setLocalDateTime(LocalDateTime.now());
		newUser.setType(true);
		newUser.setUuid(key);
		newUser.setUserId(a.getAdminId());
		cudao.save(newUser);
		return newUser.toString();
		}
		else
			throw new LoginException("Please enter a vaild password");
	}
		
		//Customer login check
		
		else if(a== null && c!=null ) {
			Optional<CurrentSession> cu = cudao.findById(c.getCoutomerId());
			if(cu.isPresent()) {
				throw new LoginException("Already loggedIn");
			}
			
			if(c.getPassword().equals(dto.getPassword())) {
				RandomString rs = new RandomString();
				String key = rs.make(6);
				CurrentSession newUser = new CurrentSession();
				newUser.setLocalDateTime(LocalDateTime.now());
				newUser.setType(true);
				newUser.setUuid(key);
				newUser.setUserId(c.getCoutomerId());
				cudao.save(newUser);
				return newUser.toString();
				
			}
			else
				throw new LoginException("Please enter a vaild password");
		}
		else {
			
				throw new LoginException("Please enter a vaild username");
		}
		
	}

	@Override
	public String logout(String key) throws LoginException {
		CurrentSession cu = cudao.findByUuid(key);
		
		if(cu == null) throw new LoginException("User not loggedin with this username");
		
		cudao.delete(cu);
		return "Logged Out";
	}

}
