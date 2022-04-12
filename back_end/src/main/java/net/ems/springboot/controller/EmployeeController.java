package net.ems.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ems.springboot.repository.EmployeeRepository;
import net.ems.springboot.exception.ResourceNotFoundException;
import net.ems.springboot.model.Employee;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employees rest API
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	//post new employee rest API
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
     //get employee by id rest API
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: " + id));
		return ResponseEntity.ok(employee);
	}
	
     //update existing employee put rest API
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Does not exist with id: " + id));
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setPhone(employeeDetails.getPhone());
		employee.setPosition(employeeDetails.getPosition());
		employee.setPosting(employeeDetails.getPosting());
		employee.setLeaves(employeeDetails.getLeaves());
		
		Employee updatedemployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedemployee);
	}
	
	//delete existing employee rest API
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Does not exist with id: "+ id));
		employeeRepository.delete(employee);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
	
	//search for string
	@PostMapping("/employees/search/{str}")
	public ResponseEntity<List<Employee>> searchEmployee(@PathVariable String str){
//		List<Employee> temp = employeeRepository.findAll();
//		List<Employee> list = new ArrayList<>();
//		for(int i = 0; i < temp.size(); i++) {
//			String name = temp.get(i).getFirstname();
//			if(name.charAt(0) == str.charAt(0)) {
//				int j = 0;
//				int k = 0;
//				while(k < name.length() && j < str.length()) {
//					if(str.charAt(j) != name.charAt(k)) {
//						break;
//					}
//					else {
//						j++;
//						k++;
//					}
//				}
//				if(j == str.length()) {
//					list.add(temp.get(i));
//				}
//			}
//		}
//		return ResponseEntity.ok(list);
//		List<Employee> list = employeeRepository.searchByfirst_name(str);
//		return ResponseEntity.ok(list);
		List<Employee> list = employeeRepository.findByfirstnameStartingWith(str);
		return ResponseEntity.ok(list);
	}
} 

