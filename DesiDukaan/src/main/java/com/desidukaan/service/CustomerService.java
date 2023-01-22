package com.desidukaan.service;

import com.desidukaan.exception.CustonerException;
import com.desidukaan.exception.LoginException;
import com.desidukaan.model.Customer;

public interface CustomerService {
	
	public Customer addCoustomer(Customer coustomer);
	
	public Customer updateCoustomer(Customer customer, String key) throws CustonerException,LoginException;
	
	public  Customer removeCustomer(Customer customer, String key) throws CustonerException,LoginException;
	
	public Customer veiwCustomerById(Integer customerId, String key) throws CustonerException,LoginException;

}
