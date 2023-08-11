package com.codingdojo.empleadosgerentes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.empleadosgerentes.models.Employee;
import com.codingdojo.empleadosgerentes.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	
	
	@GetMapping("/")
	public void employees() {
		// Manager
		Employee employee = employeeService.buscarEmpleadoById(Long.valueOf(1));
		System.out.println("Manager: "+ employee.getFirstName() + " " + employee.getLastName());

//		// Nombres de los empleados del manager
		for (Employee e : employee.getEmployees()) {
			System.out.println("Nombres de cada empleado del manager : "+e.getFirstName() + " " + e.getLastName());
		}
//
//		// Lista de usuarios que tienen de amigo al user
//		for (Employee u : employee.getUserFriends()) {
//			System.out.println("Lista de usuarios que tienen de amigo al user 1: "+u.getFirstName());
//		}
	}

}
