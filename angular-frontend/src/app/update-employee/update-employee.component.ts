import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id: number = 0;
  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    //here in the getEmployeeByiD method we need to pass id parameter 
    //and for that we need to retieve id by the route.
    //to do that we use activatedRoutes and from snapshot property of the activated route
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.log(error)) ;
  }

  onSubmit() {
    console.log(this.employee);
    this.saveEmployee(); 
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

}
