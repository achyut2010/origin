package com.acme.test.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acme.test.constants.Constants;
import com.acme.test.entity.ContactInfo;
import com.acme.test.exception.ResourceNotFoundException;
import com.acme.test.repo.ContactInfoRepo;
import com.acme.test.repo.CustomerRepo;
import com.acme.test.service.ContactInfoService;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

	@Autowired
	private CustomerRepo customerRepository;
	
	@Autowired
	private ContactInfoRepo contactInfoRepository;

	@Override
	public ContactInfo saveContactInfo(Long customerId, ContactInfo contactInfo) {
		return customerRepository.findById(customerId).map(customer -> {
        	contactInfo.setCustomer(customer);
            return contactInfoRepository.save(contactInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId));
	}

	@Override
	public Page<ContactInfo> getAll(Long customerId, Pageable pageable) {
		 return contactInfoRepository.findByCustomerId(customerId, pageable);
	}

	@Override
	public ContactInfo updateContactInfo(Long customerId, ContactInfo contactInfo) {
		if(!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId);
        }

        return customerRepository.findById(customerId).map(customer -> {
        	ContactInfo contactInfoD = customer.getContactInfo();
        	BeanUtils.copyProperties(contactInfo, contactInfoD);
            return contactInfoRepository.save(contactInfoD);
        }).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId));
	}

	@Override
	public void deleteContactInfo(Long customerId) {
		contactInfoRepository.findById(customerId).map(customer -> {
			contactInfoRepository.delete(customer);
            return null;
        }).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_ID_NOT_FOUND+customerId));
		
	}

	
}
