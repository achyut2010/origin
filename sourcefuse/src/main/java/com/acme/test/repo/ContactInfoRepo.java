package com.acme.test.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.test.entity.ContactInfo;

@Repository
public interface ContactInfoRepo extends JpaRepository<ContactInfo, Long> {

	Page<ContactInfo> findByCustomerId(Long customerId, Pageable pageable);

}
