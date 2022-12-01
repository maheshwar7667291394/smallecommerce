package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LogeinException;
import com.masai.model.Customer;
import com.masai.model.loginDTO;
import com.masai.service.CustomerServises;
import com.masai.service.logeinServises;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class MyController {
	@Autowired
	public CustomerServises cservice;
	
	@Autowired
	public logeinServises lservice;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> CreateCustoMer(@RequestBody Customer customer) throws CustomerException{
		
		Customer registercustomer=cservice.CreateCustomer(customer);
		
		return new ResponseEntity<Customer>(registercustomer,HttpStatus.OK);
		
		
		
		
	}
	
	@PutMapping("/customer/{key}")
	public ResponseEntity<Customer> UpdateCustomer(@RequestBody Customer customew,@PathVariable String key) throws CustomerException{
		
		Customer updateCustomer=cservice.UpdateCustomer(customew, key);
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
		
	}
	
	@PutMapping("/logein")
	public ResponseEntity<String> logedIn(@RequestBody loginDTO log) throws LogeinException{
		
		String login=lservice.logIntoAccount(log);
		return new ResponseEntity<>(login,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> logout(@PathVariable String key) throws LogeinException {
		String logut=lservice.logOutAccount(key);
		
		return new ResponseEntity<String>(logut,HttpStatus.OK);
		
	}

}
