package com.acme.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acme.test.entity.ContactInfo;

public interface ContactInfoService {
	ContactInfo saveContactInfo(Long customerId,ContactInfo contactInfo);
	Page<ContactInfo> getAll(Long customerId,Pageable pageable);
	ContactInfo updateContactInfo(Long customerId,ContactInfo customerRequest);
    void deleteContactInfo(Long customerId);
}
