import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({ 
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService, 
    private router: Router) { }


  ngOnInit(): void {
  }


  saveEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe (data => {
      console.log(data); //print data if success
      this.gotoEmployeeList();
    },
    error => console.log(error)); //print error
  }


  //when we submit employee data successfully we have to be able to go to  employee list page
  gotoEmployeeList() {
    this.router.navigate(['/employees']);
  }


  onSubmit() {
    console.log(this.employee);
    this.saveEmployee(); 
  }

}
