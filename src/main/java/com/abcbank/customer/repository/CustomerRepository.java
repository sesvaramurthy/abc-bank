package com.abcbank.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcbank.customer.model.CustomerInfo;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo, Long> {
	boolean existsByUsername(String username);
	Optional<CustomerInfo> findByUsernameAndPassword(String username, String password) throws RuntimeException;
}
