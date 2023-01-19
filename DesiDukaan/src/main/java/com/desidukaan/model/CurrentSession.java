package com.desidukaan.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentSession {
	@Id
	@Column(unique = true)
	private Integer userId;
	private String uuid;
	private LocalDateTime localDateTime;
	//true for admin and false for user
	private Boolean type;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public Boolean getType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	public CurrentSession(Integer userId, String uuid, LocalDateTime localDateTime, Boolean type) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
		this.type = type;
	}
	public CurrentSession() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		
		return "CurrentSession [userId=" + userId + ", uuid=" + uuid + ", localDateTime=" + localDateTime + ", type="
				+ type + "]";
	}
	
	
}
