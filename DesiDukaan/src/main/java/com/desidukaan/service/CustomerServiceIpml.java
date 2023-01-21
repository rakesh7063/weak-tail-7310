package com.desidukaan.service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidukaan.exception.CustonerException;
import com.desidukaan.exception.LoginException;
import com.desidukaan.model.CurrentSession;
import com.desidukaan.model.Customer;
import com.desidukaan.model.User;
import com.desidukaan.repository.AdminDao;
import com.desidukaan.repository.CoustomerDao;
import com.desidukaan.repository.CurrentUserDao;

@Service
public class CustomerServiceIpml implements CustomerService {
	
	@Autowired
	private CoustomerDao dao;
	
	@Autowired
	private CurrentUserDao cuu;

	@Autowired
	private AdminDao admindao;
	
	
	@Override
	public Customer addCoustomer(Customer coustomer) {
		
		
		Customer cu = dao.save(coustomer);
		return cu;
	}


	@Override
	public Customer updateCoustomer(Customer customer, String key) throws CustonerException, LoginException {
		CurrentSession cu = cuu.findByUuid(key);
		if(cu == null) throw new LoginException("Please Login first !");
		
		Optional<Customer> curentUser = dao.findById(customer.getCoutomerId());
		if(curentUser.isEmpty()) throw new  CustonerException("Customer does not exist");
		
		return dao.save(customer);
	}


	@Override
	public Customer removeCustomer(Customer customer, String key) throws CustonerException, LoginException {
		CurrentSession cu = cuu.findByUuid(key);
		if(cu == null) throw new LoginException("Please Login first !");
		
		Optional<Customer> curentUser = dao.findById(customer.getCoutomerId());
		if(curentUser.isEmpty()) throw new  CustonerException("Customer does not exist");
		
		 dao.deleteById(customer.getCoutomerId());
		 
		 return curentUser.get();
	}


	@Override
	public Customer veiwCustomerById(Integer customerId, String key) throws CustonerException, LoginException {
		
		CurrentSession cu = cuu.findByUuid(key);
		if(cu == null) throw new LoginException("Please Login first !");
		
		Optional<Customer> curentUser = dao.findById(customerId);
		if(curentUser.isEmpty()) throw new  CustonerException("Customer does not exist");
		
		return curentUser.get();
	}

	

}
