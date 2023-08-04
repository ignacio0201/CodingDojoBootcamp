package com.codingdojo.licenciamanejo.services;


import org.springframework.stereotype.Service;

import com.codingdojo.licenciamanejo.models.License;
import com.codingdojo.licenciamanejo.repositories.LicenseRepository;

@Service
public class LicenseService {

private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	// Create a license
	public License createLicense(License license) {
		
		return licenseRepository.save(license);
	}
	//Encuentra licencia por id de la persona
	public License findLicenseById(Long id) {
		
		return licenseRepository.getLicenseByPersonId(id);
	}
	
}
