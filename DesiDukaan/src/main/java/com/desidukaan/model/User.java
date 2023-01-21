package com.desidukaan.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
	



		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer userId;
		
		@Column(unique = true)
		@NotBlank(message = "User name status can't blank")
		@Size(min = 3,max = 8, message = "User name length should be 3 and 8 characters!")
		private String userName;
		
		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit " )
		private String password;
		
		
		private String role;

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}


		
		public User(Integer userId,
				@NotBlank(message = "User name status can't blank") @Size(min = 3, max = 8, message = "User name length should be 3 and 8 characters!") String userName,
				@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$", message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ") String password,
				String role) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.password = password;
			this.role = role;
		}

		public User() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
		}

		
	}


