package com.abcbank.customer.service;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abcbank.customer.exception.UsernameAlreadyExistsException;
import com.abcbank.customer.model.CustomerInfo;
import com.abcbank.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public CustomerInfo registerCustomer(CustomerInfo custInfo) {
		
		if(customerRepository.existsByUsername(custInfo.getUsername())) {
			 throw new UsernameAlreadyExistsException("Username already exists !! ");
		}
		custInfo.setIbanNumber(generateIban());
		custInfo.setPassword(generateDefaultPassword());
		
		return customerRepository.save(custInfo);
	}
	public CustomerInfo loginCustomer(String username, String password) {
		return customerRepository.findByUsernameAndPassword(username, password)
				.orElseThrow(() -> new UsernameAlreadyExistsException("username not exists"));
	}
	/**
	 * This method to generate IBAN account number for NL
	 * @return
	 */
	private String generateIban() {
		/*
		 * Random rn = new Random(); Iban iban = new Iban.Builder()
		 * .countryCode(CountryCode.NL) .bankCode("64 ABNC")
		 * .accountNumber(String.valueOf(rn.nextInt(10)+1)) .buildRandom(); return
		 * iban.toString();
		 */
		Random rand = new Random();
	    String card = "NL";
	    for (int i = 0; i < 14; i++)
	    {
	        int n = rand.nextInt(10) + 0;
	        card += Integer.toString(n);
	    }
	    for (int i = 0; i < 16; i++)
	    {
	        if(i % 4 == 0)
	          System.out.print(" ");
	        System.out.print(card.charAt(i));
	    }
	    return card;
	}
	/**
	 * This method to generate default password of length 6 alphanumeric 
	 * @return
	 */
	private String generateDefaultPassword() {
		return RandomStringUtils.randomAlphanumeric(6);
	}
}
