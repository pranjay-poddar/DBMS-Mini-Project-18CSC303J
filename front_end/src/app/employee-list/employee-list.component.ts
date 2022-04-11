import { EmployeeService } from './../employee.service';
import { Employee } from './../employee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {

  employees!: Employee[];
  searchStr ! : String;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  this.getEmployees();
  // this.employees = [{
  //   "id":1,
  //   "firstName":"pranjay",
  //   "lastName":"poddar",
  //   "emailId":"pranjaypoddar@email.com"
  // }]
  }

  private getEmployees(){
    this.employeeService.getEmplyeesList().subscribe(data=>{
      this.employees = data;
    });
  }
  
submit(){
  console.log(this.searchStr);
}
  updateemployee(id:number){
   this.router.navigate(['update',id]);
  }

  deleteemployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(data=>{
      console.log(data);
    },
    error => console.log(error));
  }

  employeeDetails(id:number){
    this.router.navigate(['details',id]);
  }

}
