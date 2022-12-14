package com.js.springboot.exception;

public class NoIdFoundException extends RuntimeException{
	private String message = "Id Does Not Exist";

	public NoIdFoundException() {
		super();
	}

	public NoIdFoundException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
