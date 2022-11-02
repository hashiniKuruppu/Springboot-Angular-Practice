package com.hnk.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.hnk.springboot.exception.EmployeeServiceException;
import com.hnk.springboot.model.Employee;
import com.hnk.springboot.repository.EmployeeRepository;

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
	public Employee getEmployeeByEmail(String emailId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
