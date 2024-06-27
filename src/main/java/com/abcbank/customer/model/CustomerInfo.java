package com.abcbank.customer.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "customerinfo")
public class CustomerInfo {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerinfo_id_seq")
	@SequenceGenerator(name = "customerinfo_id_seq", sequenceName = "customerinfo_id_seq", allocationSize = 1)
	private Long id;
	
	@NotBlank
	@Column(name = "customer_name")
	private String customerName;
	
	@NotBlank
	@Column(name = "customer_address")
	private String customerAddress;
	
	@NotNull
	@Column(name = "customer_dob")
	private Date customerDob;
	
	@Column(name = "iban_number")
	private String ibanNumber;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
}
