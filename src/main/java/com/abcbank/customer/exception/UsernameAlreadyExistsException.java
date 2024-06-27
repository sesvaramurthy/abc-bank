package com.abcbank.customer.exception;

public class UsernameAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}
	
	
}
