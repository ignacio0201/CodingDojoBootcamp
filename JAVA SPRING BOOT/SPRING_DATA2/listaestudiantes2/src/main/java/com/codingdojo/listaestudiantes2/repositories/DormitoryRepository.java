package com.codingdojo.listaestudiantes2.repositories;


import org.springframework.data.repository.CrudRepository;

import com.codingdojo.listaestudiantes2.models.Dormitory;

public interface DormitoryRepository extends CrudRepository<Dormitory, Long>{


	Dormitory findDormitoryById(Long id);
	
	
}
