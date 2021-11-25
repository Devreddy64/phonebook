package com.dev.PhoneBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value= NoDataFoundException.class)
	public ResponseEntity<String> handleNoDataFoundException(NoDataFoundException nodatafoundexception) {
		
		
		String exceptionmessage = nodatafoundexception.getMessage();
		
		return new ResponseEntity<>(exceptionmessage,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
}
