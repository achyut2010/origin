package com.acme.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acme.test.entity.Orders;

public interface OrderService {
	Orders saveOrders(Long customerId, Orders orderBo);

	Page<Orders> getAll(Long customerId, Pageable pageable);

	Orders updateOrders(Long customerId, Long orderId, Orders orderBoRequest);

	void deleteOrders(Long customerId, Long orderId);
}
