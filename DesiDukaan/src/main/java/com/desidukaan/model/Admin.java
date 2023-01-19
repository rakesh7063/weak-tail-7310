package com.desidukaan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotBlank(message = "username cannot be blank")
	@NotNull(message = "username satatus cannot be null")
	@NotEmpty(message = "username status cannot be empty")
	@Size(min = 3, max = 8, message = "Username should be 3 to 8 characters! ")
	private String username;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit " )
	private String password;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

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

	public Admin(Integer adminId,
			@NotBlank(message = "username cannot be blank") @NotNull(message = "username satatus cannot be null") @NotEmpty(message = "username status cannot be empty") @Size(min = 3, max = 8, message = "Username should be 3 to 8 characters! ") String username,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$", message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ") String password) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + "]";
	}
	
}
