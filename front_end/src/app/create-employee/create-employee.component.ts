import { EmployeeService } from './../employee.service';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.scss']
})
export class CreateEmployeeComponent implements OnInit {

  employee : Employee = new Employee();
constructor(private employeeService:EmployeeService,private router:Router) { }

ngOnInit(): void {}

saveEmployee(){
  this.employeeService.createEmployee(this.employee).subscribe(data=>{
    console.log("success" + data);
  },
  error => console.log(error));
  this.goToEmployeeList();
}
  
goToEmployeeList(){
  this.router.navigate(['/employees']);
}
onSubmit(){
console.log(this.employee);
this.saveEmployee();
}
}
