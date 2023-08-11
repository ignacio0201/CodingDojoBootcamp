package com.codingdojo.empleadosgerentes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.empleadosgerentes.models.Employee;
import com.codingdojo.empleadosgerentes.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired private EmployeeRepository employeeRepository;
	
	public List<Employee> todosLosEmpleados() {
		return employeeRepository.findAll();
	}
	
	public Employee crearEmpleado(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee buscarEmpleadoById(Long id) {
		java.util.Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}	
	}

	
	
}
