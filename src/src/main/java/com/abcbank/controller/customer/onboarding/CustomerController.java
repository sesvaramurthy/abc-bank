package com.abcbank.controller.customer.onboarding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.model.customer.onboarding.CustomerInfo;
import com.abcbank.service.customer.onboarding.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody CustomerInfo custInfo) {
		CustomerInfo savedCustInfo = customerService.registerCustomer(custInfo);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Customer Register Successfull Username : " + savedCustInfo.getUsername() + " Password : " + savedCustInfo.getPassword());
	}
}
