package com.codingdojo.listaestudiantes2.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.listaestudiantes2.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findAll();
	
	Student findStudentById(Long id);
	
//	Student deleteStudentByIdFromDormitory(Long idStudent, Long idDormitory);
	
//	Student RemoveStudentByIdFromDormitory(Long id);
}
