package com.js.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.js.springboot.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(value = NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdFound(NoIdFoundException e){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setData(e.getMessage());
		responseStructure.setMessage("Failed");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
