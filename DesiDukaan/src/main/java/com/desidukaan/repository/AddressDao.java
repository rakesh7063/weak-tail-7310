package com.desidukaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desidukaan.exception.AddressException;
import com.desidukaan.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
	
	@Query("select a from Address a where a.state = ?1")
	public Address viewAddressByState(String state) throws AddressException;

}
