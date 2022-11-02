package com.hnk.springboot.service;

import com.hnk.springboot.exception.EmployeeServiceException;
import com.hnk.springboot.model.Employee;

public interface EmployeeService {
	
	static Employee saveEmployee(Employee employee) throws EmployeeServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	Employee getEmployeeByEmail (String emailId, String password);

}
