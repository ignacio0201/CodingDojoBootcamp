package com.codingdojo.listaestudiantes2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.listaestudiantes2.models.ContactInfo;
import com.codingdojo.listaestudiantes2.models.Dormitory;
import com.codingdojo.listaestudiantes2.models.Student;
import com.codingdojo.listaestudiantes2.services.ContactInfoService;
import com.codingdojo.listaestudiantes2.services.DormitoryService;
import com.codingdojo.listaestudiantes2.services.StudentService;

@RestController
public class HomeController {
	
	private final StudentService studentService;
	private final ContactInfoService contactInfoService;
	private final DormitoryService dormitoryService;
	
	public HomeController(StudentService studentService, ContactInfoService contactInfoService, DormitoryService dormitoryService) {
		this.studentService = studentService;
		this.contactInfoService = contactInfoService;
		this.dormitoryService = dormitoryService;
		}
	
	//Crear estudiante
	@GetMapping("/students/create")
	public Student createStudent(
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="age") String age) {
		
		Student student = new Student(firstName, lastName, age);
		return studentService.createStudent(student);
	}
	
	//Crear contacto a estudiante especifico
	@GetMapping("/contacts/create")
	public ContactInfo createContact(
			@RequestParam(value="student")Long studentId,
			@RequestParam(value="address") String address,
			@RequestParam(value="city") String city,
			@RequestParam(value="state") String state) {
		
		Student student = studentService.findStudentById(studentId);
		ContactInfo contact = new ContactInfo(null, address, city, state, null, null, student);
		return contactInfoService.createContact(contact);
	}
	
	//Crear dormitorio
	@GetMapping("/dorms/create")
	public Dormitory createDormitory(
			@RequestParam(value = "name") String name) {
		
		Dormitory dormitory = new Dormitory(name);
		return dormitoryService.createDormitory(dormitory);
	}
	
	//Agregar estudiante a un dormitorio especifico
	@GetMapping("/dorms/{dormitory}/add") //PROBAAAAAAR
	public Student addStudentDormitory(
			@PathVariable("dormitory") Long idDormitory,
			@RequestParam("student") Long idStudent) {
		
		Student student = studentService.findStudentById(idStudent);
		Dormitory dormitory = dormitoryService.findDormitoryById(idDormitory);
		student.setDormitory(dormitory);
		return studentService.createStudent(student);
	}
	//Eliminar estudiante de un dormitorio
	@DeleteMapping("/dorms/{dormitory}/remove")
	public Student removeStudentDormitory(
			@PathVariable("dormitory") Long idDormitory,
			@RequestParam("student") Long idStudent) {
		
		Student student = studentService.findStudentById(idStudent);
		student.setDormitory(null);
		return studentService.createStudent(student);
	}
	//Mostrar todos los estudiantes de un dormitorio por id
	@GetMapping("/dorms/{idDormitory}")
	public Dormitory findStudentsFromDormitoryById(
			@PathVariable("idDormitory") Long idDormitory) {
		Dormitory dormitory = new Dormitory();
		dormitory = dormitoryService.findDormitoryById(idDormitory);
		return dormitory;
	}
	
	//Mostrar lista estudiantes
	@GetMapping("/students")
	public List<Student> showAllStudents(){
		return studentService.findAllStudents();
	}
	
}
