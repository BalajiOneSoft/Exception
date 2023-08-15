package com.myapp.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class EmployeeExceptions {
	
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity <Object> NameNotFoundHandling(InvalidNameException n){
		
		return new ResponseEntity<> (n.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity <Object> IdNotFoundHandling(InvalidIdException i){
		
		return new ResponseEntity<> (i.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}
	

}
