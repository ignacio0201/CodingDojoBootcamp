package com.codingdojo.listaestudiantes1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.listaestudiantes1.models.ContactInfo;
import com.codingdojo.listaestudiantes1.models.Student;
import com.codingdojo.listaestudiantes1.repositories.ContactInfoRepository;
import com.codingdojo.listaestudiantes1.repositories.StudentRepository;
import com.codingdojo.listaestudiantes1.services.ContactInfoService;
import com.codingdojo.listaestudiantes1.services.StudentService;

@RestController
public class HomeController {
	
	private final StudentService studentService;
	private final ContactInfoService contactInfoService;
	
	public HomeController(StudentService studentService, ContactInfoService contactInfoService) {
		this.studentService = studentService;
		this.contactInfoService = contactInfoService;
		}
	

	@GetMapping("/students/create")
	public Student createStudent(
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="age") String age) {
		Student student = new Student(firstName, lastName, age);
		return studentService.createStudent(student);
	}
	@GetMapping("/contacts/create")
	public ContactInfo createContact(
			@RequestParam(value="student")Long studentId,
			@RequestParam(value="address") String address,
			@RequestParam(value="city") String city,
			@RequestParam(value="state") String state) {
		
		Optional<Student> idStudent = studentService.findStudentById(studentId);
		Student student = idStudent.get();
		ContactInfo contact = new ContactInfo(null, address, city, state, null, null, student);
		
		return contactInfoService.createContact(contact);
	}
	
	@GetMapping("/students")
	public List<Student> showAllStudents(){
		return studentService.findAllStudents();
	}
	
}
