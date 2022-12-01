package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerServises {
	
	public Customer CreateCustomer(Customer customer)throws CustomerException;
	public Customer UpdateCustomer(Customer customer,String key)throws CustomerException;

}
