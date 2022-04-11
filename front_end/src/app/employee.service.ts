import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  // private baseURL = "https://employeemanagementserver.herokuapp.com/api/v1/employees";
  private baseURL = "http://localhost:8085/api/v1/employees";
  constructor(private httpClient : HttpClient) { }

  getEmplyeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  createEmployee(employee:Employee):Observable<any>{
  return this.httpClient.post(`${this.baseURL}`,employee);
  }

  getEmployeeById(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id:number,employee : Employee):Observable <Employee>{
    return this.httpClient.put<Employee>(`${this.baseURL}/${id}`,employee); 
  }

  deleteEmployee(id:number):Observable <any>{
    return this.httpClient.delete<any>(`${this.baseURL}/${id}`);
  }
}
