package com.hnk.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hnk.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public Employee findByFirstName(String firstName);

	public Employee findByLastName(String lastName);
	
	@Query("SELECT e FROM Employee e WHERE e.emailId = :email")
	public Employee findByEmail(@Param ("email") String email);
	
}

