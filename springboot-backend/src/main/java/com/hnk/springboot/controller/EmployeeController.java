package com.hnk.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnk.springboot.exception.ResourceNotFoundException;
import com.hnk.springboot.model.Employee;
import com.hnk.springboot.repository.EmployeeRepository ;

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

	@GetMapping("/employees/firstName/{firstName}")
	public Employee getByFirstName(@PathVariable String firstName){
		 return employeeRepository.findByFirstName(firstName);	
	}
	
	@GetMapping("/employees/lastName/{lastName}")
	public Employee getByLastName(@PathVariable String lastName) {
		return employeeRepository.findByLastName(lastName);
	}
	
	//create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee with id " + id + "does  not exist"));
		return ResponseEntity.ok(employee);
	}
}
