package com.acme.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.test.entity.Orders;
import com.acme.test.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/{customerId}/order")
public class OrderController extends AcmeController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
    public Page<Orders> getAllOrderBosByCustomerId(@PathVariable (value = "customerId") Long customerId,
                                                Pageable pageable) {
        return orderService.getAll(customerId, pageable);
    }

    @PostMapping
    public Orders createOrderBo(@PathVariable (value = "customerId") Long customerId,
                                 @Valid @RequestBody Orders orderBo) {
        return orderService.saveOrders(customerId, orderBo);
    }

    @PutMapping("/{orderId}")
    public Orders updateOrderBo(@PathVariable (value = "customerId") Long customerId,
                                 @PathVariable (value = "orderId") Long orderId,
                                 @Valid @RequestBody Orders orderBoRequest) {
        return orderService.updateOrders(customerId, orderId, orderBoRequest);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrderBo(@PathVariable (value = "customerId") Long customerId,
                              @PathVariable (value = "orderId") Long orderId) {
    	orderService.deleteOrders(customerId, orderId);
    	return ResponseEntity.noContent().build();
    }
}
