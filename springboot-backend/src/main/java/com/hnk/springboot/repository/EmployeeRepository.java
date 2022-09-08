package com.hnk.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hnk.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public Employee findByFirstName(String firstName);

	public Employee findByLastName(String firstName);
	
}
