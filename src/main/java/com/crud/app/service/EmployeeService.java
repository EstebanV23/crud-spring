package com.crud.app.service;

import com.crud.app.entity.Employee;

import java.util.List;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public void save (Employee employee);
	
	public Employee FindOne(Long id);
	
	public void delete(Long id);

}
