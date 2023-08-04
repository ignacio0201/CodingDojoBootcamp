package com.codingdojo.licenciamanejo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.licenciamanejo.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	
	// Este método recupera todas las personas de la base de datos
	List<License> findAll();
	
	//Encuentra la licencia por el id
	License getLicenseByPersonId(Long id);
	
	

	// Este método encuentra un libro por su descripción**
//	List<Person> findByDescriptionContaining(String search);

	// Este método cuenta cuántos libros contiene cierta cadena en el título**
//	Long countByTitleContaining(String search);

	// Este método borra un libro que empieza con un título específico **
//	Long deleteByTitleStartingWith(String search);
	
}
