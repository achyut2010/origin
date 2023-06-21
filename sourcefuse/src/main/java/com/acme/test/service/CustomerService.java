package com.acme.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acme.test.entity.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	Page<Customer> getAll(Pageable pageable);
    Customer updateCustomer(Customer customerRequest, Long customerId);
    void deleteCustomer(long id);
}
