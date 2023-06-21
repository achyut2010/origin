package com.acme.test.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.test.entity.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

	Optional<Orders> findByIdAndcustomerId(Long orderId, Long customerId);

	Page<Orders> findByCustomerId(Long customerId, Pageable pageable);

}
