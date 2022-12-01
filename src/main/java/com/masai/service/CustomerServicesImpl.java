package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.CustomerDao;
import com.masai.Repository.SessonDao;
import com.masai.exception.CustomerException;
import com.masai.model.CurrentUserSesson;
import com.masai.model.Customer;


@Service
public class CustomerServicesImpl implements CustomerServises{
	@Autowired
	public CustomerDao cdao;
	
	@Autowired
	public SessonDao sdao;

	@Override
	public Customer CreateCustomer(Customer customer) throws CustomerException {
		
		Customer ExistingCustomer=cdao.findBymobileNo(customer.getMobileNo());
		
		if(ExistingCustomer!=null) {
			throw new CustomerException("Customer already register with mobile number");
		}
		
		return cdao.save(customer);
	
	
	}

	@Override
	public Customer UpdateCustomer(Customer customer, String key) throws CustomerException {
		
		CurrentUserSesson logedincustomer=sdao.findByuuid(key);
		if(logedincustomer!=null) {
			throw new CustomerException("plese provide customer key");
		}
		
		if(customer.getCustomerId()==logedincustomer.getUserId()) {
			return cdao.save(customer);
		}
		else {
			throw new CustomerException("invalid customer details plese login first");
		}
		
	
	}

}
