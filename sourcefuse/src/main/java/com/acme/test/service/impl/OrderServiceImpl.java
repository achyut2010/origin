package com.acme.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acme.test.constants.Constants;
import com.acme.test.entity.Orders;
import com.acme.test.exception.ResourceNotFoundException;
import com.acme.test.repo.CustomerRepo;
import com.acme.test.repo.OrderRepo;
import com.acme.test.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderBoRepository;
	
	@Autowired
	private CustomerRepo customerRepository;

	@Override
	public Orders saveOrders(Long customerId, Orders orderBo) {
		return customerRepository.findById(customerId).map(customer -> {
        	orderBo.setCustomer(customer);
            return orderBoRepository.save(orderBo);
        }).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId));
	}

	@Override
	public Page<Orders> getAll(Long customerId, Pageable pageable) {
		return orderBoRepository.findByCustomerId(customerId, pageable);
	}

	@Override
	public Orders updateOrders(Long customerId, Long orderId, Orders orderBoRequest) {
		if(!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId);
        }

        return orderBoRepository.findById(orderId).map(order -> {
        	order.setProductName(orderBoRequest.getProductName());
            return orderBoRepository.save(order);
        }).orElseThrow(() -> new ResourceNotFoundException(Constants.ORDER_ID_NOT_FOUND+orderId));
	}

	@Override
	public void deleteOrders(Long customerId, Long orderId) {
		 orderBoRepository.findByIdAndcustomerId(orderId, customerId).map(order -> {
        	orderBoRepository.delete(order);
            return null;
        }).orElseThrow(() -> new ResourceNotFoundException(Constants.ORDER_ID_NOT_FOUND+orderId+ " and "+Constants.CUSTOMER_ID_NOT_FOUND+customerId));
		
	}
	
	
	
}
