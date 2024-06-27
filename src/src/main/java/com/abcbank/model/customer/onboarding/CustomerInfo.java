package com.abcbank.model.customer.onboarding;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "customerinfo")
public class CustomerInfo {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerinfo_id_seq")
	private Long id;
	
	@NotBlank
	private String customerName;
	
	@NotBlank
	private String customerAddress;
	
	@NotBlank
	private Date customerDob;
	
	private String ibanNumber;
	
	private String username;
	
	private String password;
}
