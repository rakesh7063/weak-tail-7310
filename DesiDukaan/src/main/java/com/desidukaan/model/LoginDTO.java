package com.desidukaan.model;

public class LoginDTO {

	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminDTO [username=" + username + ", password=" + password + "]";
	}
	
	
}
