package com.abcbank.repository.customer.onboarding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcbank.model.customer.onboarding.CustomerInfo;

//import com.abcbank.model.customer.onboarding.CustomerInfo;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo, Long> {
	boolean existsByUsername(String username);
	CustomerInfo findByUsernameAndPassword(String username, String password) throws RuntimeException;
}
