package com.masai.exception;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelException {
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> getCustomerException(CustomerException ce,WebRequest req){
		
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LogeinException.class)
	public ResponseEntity<MyError> getLoginException(LogeinException ce,WebRequest req){
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyError> getCategoryException(CategoryException ce,WebRequest req){
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
	
		
	}
	
	@ExceptionHandler(SerchProductException.class)
	public ResponseEntity<MyError> getproductException(SerchProductException ce,WebRequest req){
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler(AddProductException.class)
	public ResponseEntity<MyError> addproductException(AddProductException ce,WebRequest req){
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> getAllException(Exception ce,WebRequest req){

		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}

}
