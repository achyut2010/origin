package com.acme.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acme.test.constants.Constants;
import com.acme.test.entity.Customer;
import com.acme.test.exception.ResourceNotFoundException;
import com.acme.test.repo.CustomerRepo;
import com.acme.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    private CustomerRepo customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Page<Customer> getAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public Customer updateCustomer(Customer customerRequest, Long customerId) {
		 return customerRepository.findById(customerId).map(customer -> {
	        	customer.setName(customerRequest.getName());
	            return customerRepository.save(customer);
	        }).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId));
	}

	@Override
	public void deleteCustomer(long customerId) {
		customerRepository.findById(customerId).map(customer -> {
            customerRepository.delete(customer);
            return null;
        }).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId));
		
	}
	
}
