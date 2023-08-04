package com.codingdojo.listaestudiantes1.services;

import org.springframework.stereotype.Service;

import com.codingdojo.listaestudiantes1.models.ContactInfo;
import com.codingdojo.listaestudiantes1.repositories.ContactInfoRepository;

@Service
public class ContactInfoService {

private final ContactInfoRepository contactInfoRepository;
	
	public ContactInfoService(ContactInfoRepository contactInfoRepository) {
		this.contactInfoRepository = contactInfoRepository;
	}
	
	// Create a student
	public ContactInfo createContact(ContactInfo contact) {
		return contactInfoRepository.save(contact);
	}
}
