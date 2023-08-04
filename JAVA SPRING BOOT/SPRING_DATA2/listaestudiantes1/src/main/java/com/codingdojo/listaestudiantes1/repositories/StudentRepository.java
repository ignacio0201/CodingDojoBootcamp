package com.codingdojo.listaestudiantes1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.listaestudiantes1.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findAll();
	

	Optional<Student> findById(Long id);
}
