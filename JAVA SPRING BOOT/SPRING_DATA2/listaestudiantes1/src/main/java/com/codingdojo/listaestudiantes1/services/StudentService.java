package com.codingdojo.listaestudiantes1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.listaestudiantes1.models.Student;
import com.codingdojo.listaestudiantes1.repositories.StudentRepository;

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
	public Optional<Student> findStudentById(Long id){
		return studentRepository.findById(id);
	}
	
}
