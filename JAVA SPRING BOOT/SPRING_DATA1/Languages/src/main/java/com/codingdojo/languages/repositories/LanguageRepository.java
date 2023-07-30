package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	
//	//Este método recupera todos los libros de la base de datos //select * from books
    List<Language> findAll();
//    //Este método encuentra un libro por su descripción //where description = 
//    List<Language> findByDescriptionContaining(String search);
//    //Este método cuenta cuántos libros contiene cierta cadena en el título //count
//    Long countByTitleContaining(String search);
//    //Este método borra un libro que empieza con un título específico // delete where title =
//    Long deleteByTitleStartingWith(String search);
	
}
