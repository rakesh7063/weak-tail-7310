package com.desidukaan.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> adminExceptionHandle(AdminException ie , WebRequest req){
		
		MyErrorDetails er = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> orderExceptionHandle(OrderException ie , WebRequest req){

		MyErrorDetails er = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandle(LoginException ie , WebRequest req){
		
		MyErrorDetails er = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> cartExceptionHandle(CartException ie , WebRequest req){

		MyErrorDetails er = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> anyExceptionHandle(Exception e,WebRequest w){
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noFonudExceptionhandle(NoHandlerFoundException e,WebRequest w){
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<MyErrorDetails> myValidationExceptionHandle(MethodArgumentNotValidException ie){
	        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),"validation Error", ie.getBindingResult().getFieldError().getDefaultMessage());
	        
	        
	        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

	    }
}
