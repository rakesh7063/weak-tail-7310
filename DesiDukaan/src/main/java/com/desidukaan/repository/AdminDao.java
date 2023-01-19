package com.desidukaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidukaan.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	public Admin findByUsername(String username);

}
