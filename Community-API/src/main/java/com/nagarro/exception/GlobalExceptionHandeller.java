package com.nagarro.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandeller {
	
	// Handelling RunTime Exception
	public ResponseEntity<?> handelResourseNotFoundException(ResourseNotFoundException exception , WebRequest request) {
		ErrorDetails err = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
	}
	
	// Handelling Global Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handelGlobalException(Exception exception, WebRequest request) {
		ErrorDetails err = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
