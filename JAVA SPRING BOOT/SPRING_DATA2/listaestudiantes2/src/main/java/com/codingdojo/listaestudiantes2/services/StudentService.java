package com.codingdojo.listaestudiantes2.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.codingdojo.listaestudiantes2.models.Student;
import com.codingdojo.listaestudiantes2.repositories.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	// Create a student
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	//Find all students
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
	//Find student by id
	public Student findStudentById(Long id){
		return studentRepository.findStudentById(id);
	}
	//Remove student by id from dormitory
//	public Student deleteStudentByIdFromDormitory(Long idStudent, Long idDormitory) {
//		return studentRepository.deleteStudentByIdFromDormitory(idStudent, idDormitory);
//		
//	}
	
	
	
	//Remove student by id from dormitory
//	public Student removeStudentByIdFromDormitory(Long id) {
//		return studentRepository.RemoveStudentByIdFromDormitory(id);
//	}
	
}
