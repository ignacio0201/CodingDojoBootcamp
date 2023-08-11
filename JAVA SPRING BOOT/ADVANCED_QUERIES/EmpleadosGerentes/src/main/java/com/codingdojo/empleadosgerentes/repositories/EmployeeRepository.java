package com.codingdojo.empleadosgerentes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.empleadosgerentes.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	public Employee findEmployeeById(Long valueOf);
	
	public List<Employee> findAll();

}
