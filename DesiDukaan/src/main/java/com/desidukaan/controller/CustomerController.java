package com.desidukaan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.desidukaan.model.Customer;
import com.desidukaan.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService cuser;
	

	@PostMapping("/cutomer/add")
	public ResponseEntity<Customer> registerCustomerHandle(@Valid @RequestBody Customer cus){
		return new ResponseEntity<>(cuser.addCoustomer(cus),HttpStatus.CREATED);
	}

}
