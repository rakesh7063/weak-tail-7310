package com.desidukaan.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer  {
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer coutomerId;
	
	@NotNull
	@Size(min = 3, max = 10, message = "First Name length should be 3 and 10")
	private String firstName;
	
	@NotNull
	@Size(min = 3, max = 10, message = "Last Name length should be 3 and 10")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Mobile number should be 10 digit")
	private String mobileNumber;
	
	@Email(message = "Please Enter vaild email address")
	private String email;
	
	@Column(unique = true)
	@NotBlank(message = "User name status can't blank")
	@Size(min = 3,max = 8, message = "User name length should be 3 and 8 characters!")
	private String userName;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit " )
	private String password;
	
	
	public Integer getCoutomerId() {
		return coutomerId;
	}

	public void setCoutomerId(Integer coutomerId) {
		this.coutomerId = coutomerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer coutomerId,
			@NotNull @Size(min = 3, max = 10, message = "First Name length should be 3 and 10") String firstName,
			@NotNull @Size(min = 3, max = 10, message = "Last Name length should be 3 and 10") String lastName,
			@Size(min = 10, max = 10, message = "Mobile number should be 10 digit") String mobileNumber,
			@Email(message = "Please Enter vaild email address") String email,
			@NotBlank(message = "User name status can't blank") @Size(min = 3, max = 8, message = "User name length should be 3 and 8 characters!") String userName,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$", message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ") String password) {
		super();
		this.coutomerId = coutomerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [coutomerId=" + coutomerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", userName=" + userName + ", password="
				+ password + "]";
	}

	
	

	

	
	
}
