package com.abcbank.service.customer.onboarding;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
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
	/**
	 * This method to generate IBAN account number for NL
	 * @return
	 */
	private String generateIban() {
		Random rn = new Random();
		Iban iban = new Iban.Builder()
                .countryCode(CountryCode.NL)
                .bankCode("64 ABNC")
                .accountNumber(String.valueOf(rn.nextInt(10)+1))
                .buildRandom();
		return iban.toString();
	}
	/**
	 * This method to generate default password of length 6 alphanumeric 
	 * @return
	 */
	private String generateDefaultPassword() {
		return RandomStringUtils.randomAlphanumeric(6);
	}
}
