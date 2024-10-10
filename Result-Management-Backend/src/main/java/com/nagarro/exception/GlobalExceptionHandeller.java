package com.nagarro.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandeller {

	// handelling ResourseNotFound Exception
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<?> handelResourseNotFoundException(ResourseNotFoundException exception, WebRequest request) {
		ErrorDetalis err = new ErrorDetalis(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
	}

	// handelling BadRequest Exception
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> handelBadRequestException(BadRequestException exception, WebRequest request) {
		ErrorDetalis err = new ErrorDetalis(new Date(), "Bad Request : " + exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
	}

	// Handelling Global Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handelGlobalException(Exception exception, WebRequest request) {
		ErrorDetalis err = new ErrorDetalis(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
