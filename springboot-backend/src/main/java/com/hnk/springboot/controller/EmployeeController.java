package com.hnk.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnk.springboot.exception.EmployeeServiceException;
import com.hnk.springboot.exception.ResourceNotFoundException;
import com.hnk.springboot.model.Employee;
import com.hnk.springboot.repository.EmployeeRepository ;
import com.hnk.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employees
	@GetMapping("/employees")
	public List <Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	
	//create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeServiceException {
		
		return EmployeeService.saveEmployee(employee);
		
	}
	
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee with id " + id + " does  not exist"));
		
		return ResponseEntity.ok(employee);
		
	}
	
	
	//update employee rest API
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee with id " + id + "does  not exist"));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setUserName(employeeDetails.getUserName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	

	//delete employee rest API
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee with id " + id + "does  not exist"));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	//login
	@GetMapping("/employees/login")
	public ResponseEntity<Employee> employeeLogin(@RequestParam String emailId, String password, @RequestBody Employee employee) throws EmployeeServiceException {
		
		try {
			Employee emp = employeeRepository.findByEmail(emailId);
			return ResponseEntity.ok(emp);
		}
		catch (ResourceNotFoundException e) {
			throw new EmployeeServiceException("404", "Employee with email "+emailId+" does not exist.");
		}
		
	}
	
}
