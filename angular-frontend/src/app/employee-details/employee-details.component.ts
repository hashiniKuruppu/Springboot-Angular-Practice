import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: number = 0
  employee: Employee = {
    id: 0,
    firstName: '',
    lastName: '',
    userName: '',
    emailId: '',
    password: ''
  }

  constructor(private route: ActivatedRoute, 
    private employeeService: EmployeeService ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employee = new Employee();
    this.employeeService.getEmployeeById(this.id).subscribe( data => {
      this.employee = data;
    });
  }

}
