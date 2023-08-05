package com.codingdojo.dojosninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojosninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	
	//RECUPERA TODOS LOS DOJOS
	List<Dojo> findAll();
	
	Optional<Dojo> findById(Long id);
	
}
