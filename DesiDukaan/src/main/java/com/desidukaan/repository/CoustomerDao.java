package com.desidukaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidukaan.model.Admin;
import com.desidukaan.model.Customer;

@Repository

public interface CoustomerDao extends JpaRepository<Customer, Integer>{
	public Customer findByUserName(String username);
}
