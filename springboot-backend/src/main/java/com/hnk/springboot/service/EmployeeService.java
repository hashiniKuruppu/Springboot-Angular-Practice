package com.hnk.springboot.service;

import org.springframework.http.ResponseEntity;

import com.hnk.springboot.exception.EmployeeServiceException;
import com.hnk.springboot.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee) throws EmployeeServiceException;
	
	Employee getEmployeeByEmail (String emailId, String password) throws EmployeeServiceException;

}
