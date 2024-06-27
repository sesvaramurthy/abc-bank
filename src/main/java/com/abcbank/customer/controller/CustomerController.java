package com.abcbank.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.customer.model.CustomerInfo;
import com.abcbank.customer.model.LoginRequest;
import com.abcbank.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> register(@Valid @RequestBody CustomerInfo custInfo) {
		CustomerInfo savedCustInfo = customerService.registerCustomer(custInfo);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Customer Register Successfull Username : " + savedCustInfo.getUsername() + " Password : " + savedCustInfo.getPassword());
	}
	
	@GetMapping("/register")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> register() {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Customer Register Successfull Username : " + "sivalingam" + " Password : " + "fsfsdfh");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginReq) {
		CustomerInfo custInfo = customerService.loginCustomer(loginReq.getUsername(), loginReq.getPassword());
		return ResponseEntity.ok("Customer Register Successfull Username : " + custInfo.getUsername() + " Password : " + custInfo.getPassword());
	}
}
