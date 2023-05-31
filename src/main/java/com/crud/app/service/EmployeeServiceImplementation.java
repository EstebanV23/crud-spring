package com.crud.app.service;

import com.crud.app.entity.Employee;
import com.crud.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll(){
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee FindOne(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

}
