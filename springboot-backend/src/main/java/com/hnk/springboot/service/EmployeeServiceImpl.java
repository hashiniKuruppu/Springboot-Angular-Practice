package com.hnk.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hnk.springboot.exception.EmployeeServiceException;
import com.hnk.springboot.exception.ResourceNotFoundException;
import com.hnk.springboot.model.Employee;
import com.hnk.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeServiceException {
		try {
			return employeeRepository.save(employee);
		}
		catch(DataIntegrityViolationException e) {
			throw new EmployeeServiceException("1002", "employee already exists");
		}
	}

	@Override
	public Employee getEmployeeByEmail(String emailId, String password) throws EmployeeServiceException {
		try {
			Employee emp = employeeRepository.findByEmail(emailId);
			return emp;
		}
		catch (ResourceNotFoundException e) {
			throw new EmployeeServiceException("404", "Employee with email "+emailId+" does not exist.");
		}
	}



}
