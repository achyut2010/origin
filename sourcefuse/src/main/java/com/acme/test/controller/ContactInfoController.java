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

import com.acme.test.entity.ContactInfo;
import com.acme.test.service.ContactInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/{customerId}/contactinfo")
public class ContactInfoController extends AcmeController {
	
	@Autowired
	private ContactInfoService contactInfoService;
	
	@GetMapping
    public Page<ContactInfo> getAllContactInfoByCustomerId(@PathVariable (value = "customerId") Long customerId,
                                                Pageable pageable) {
        return contactInfoService.getAll(customerId, pageable);
    }

    @PostMapping
    public ContactInfo createContactInfo(@PathVariable (value = "customerId") Long customerId,
                                 @Valid @RequestBody ContactInfo contactInfo) {
        return contactInfoService.saveContactInfo(customerId, contactInfo);
    }

    @PutMapping("/{customerId}")
    public ContactInfo updateContactInfo(@PathVariable (value = "customerId") Long customerId,
                                 @Valid @RequestBody ContactInfo contactInfo) {
        return contactInfoService.updateContactInfo(customerId, contactInfo);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> deleteContactInfo(@PathVariable (value = "customerId") Long customerId) {
    	contactInfoService.deleteContactInfo(customerId);
        return ResponseEntity.noContent().build();
    }
}
