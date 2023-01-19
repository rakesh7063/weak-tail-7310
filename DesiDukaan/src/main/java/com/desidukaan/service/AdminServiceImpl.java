package com.desidukaan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidukaan.model.Admin;
import com.desidukaan.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao admindao;

	@Override
	public Admin registerAdmin(Admin admin) {
		
		return admindao.save(admin);
	}
	
	

}
