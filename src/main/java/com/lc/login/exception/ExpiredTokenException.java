package com.lc.login.exception;

public class ExpiredTokenException extends Exception {

	public ExpiredTokenException() {
		super();
	}
	
	public ExpiredTokenException(String message) {
		super(message);
	}
	
}
