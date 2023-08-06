package com.codingdojo.listaestudiantes2.services;

import org.springframework.stereotype.Service;

import com.codingdojo.listaestudiantes2.models.Dormitory;
import com.codingdojo.listaestudiantes2.repositories.DormitoryRepository;

@Service
public class DormitoryService {
	
	private final DormitoryRepository dormitoryRepository;
	public DormitoryService(DormitoryRepository dormitoryRepository) {
		this.dormitoryRepository = dormitoryRepository;
	}
	
	
	// Create a dormitory
	public Dormitory createDormitory(Dormitory dormitory) {
			return dormitoryRepository.save(dormitory);
	}
	
	// Find dormitory by id
	public Dormitory findDormitoryById(Long id) {
		return dormitoryRepository.findDormitoryById(id);
	}
	
	
}
