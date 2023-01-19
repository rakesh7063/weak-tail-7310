package com.desidukaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidukaan.model.CurrentSession;

@Repository
public interface CurrentUserDao extends JpaRepository<CurrentSession, Integer> {
	
	public CurrentSession findByUuid(String key);

}
