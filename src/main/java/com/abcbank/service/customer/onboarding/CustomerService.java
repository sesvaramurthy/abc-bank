package com.abcbank.service.customer.onboarding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.exception.customer.onboarding.UsernameAlreadyExistsException;
import com.abcbank.model.customer.onboarding.CustomerInfo;
import com.abcbank.repository.customer.onboarding.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerInfo registerCustomer(CustomerInfo custInfo) {
		
		if(customerRepository.existsByUsername(custInfo.getUsername())) {
			 throw new UsernameAlreadyExistsException("Username already exists !! ");
		}
		custInfo.setIbanNumber(generateIban());
		custInfo.setPassword(generateDefaultPassword());
		
		return customerRepository.save(custInfo);
	}
	public CustomerInfo loginCustomer(String username, String password) {
		try {
			return customerRepository.findByUsernameAndPassword(username, password);
		} catch (RuntimeException re) {
			throw new RuntimeException("Invalid username and password");
		}
	}
	
	private String generateIban() {
		return null;
	}
	private String generateDefaultPassword() {
		return null;
	}
}
