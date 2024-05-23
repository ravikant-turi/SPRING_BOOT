package com.example.EmployeeManagementSystem.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
     
	 @Autowired
	 EmployeeRepository employeeRepository;
	 
	 
	 @PostMapping("/employee")
	 public String  employeeRepositoryy(@RequestBody Employee employee) {
		 employeeRepository.save(employee);
		 return "emplyee created in database";
		 
		 
		 
	 }
	
	 @GetMapping("/employee")
	 public ResponseEntity<List<Employee>> getAllEmployee(){
		 
		 List<Employee> empList=new ArrayList<>();
		 employeeRepository.findAll().forEach(empList::add);
		 return new ResponseEntity<List<Employee>> (empList,HttpStatus.OK);
		 
	 }
	 @GetMapping("/employee/{emp_id}")
	 public ResponseEntity<Employee> getEmplyeeById(@PathVariable long emp_id){
		 
		Optional<Employee>emp=employeeRepository.findById(  emp_id);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	 }
	 @PutMapping("/employee/{emp_id}")
	 public String updataeEmployeeById(@PathVariable long emp_id,@RequestBody Employee employee){
		 
			Optional<Employee>emp=employeeRepository.findById( emp_id);
			
			if(emp.isPresent()) {
				  Employee existEmployee=emp.get();
				  existEmployee.setEmp_age(employee.getEmp_age());
				  existEmployee.setEmp_city(employee.getEmp_city());
				  existEmployee.setEmp_name(employee.getEmp_name());
				  existEmployee.setEmp_salary(employee.getEmp_salary());
				  employeeRepository.save(existEmployee);
				  return "employee details against Id :" + emp_id+ "     updated";
			}
			else {
				return "employee details does Not exist for employeeId : "+ emp_id;
			}
	 }
	 @DeleteMapping("/employee/{emp_id}")
	 public String deleteEmployeeById(@PathVariable long emp_id){
		 
			Optional<Employee>emp=employeeRepository.findById( emp_id);
			
			if(emp.isPresent()) {

				
				employeeRepository.deleteById( emp_id);
				return "deleted sucussesfully !";
			}
			else {
				return "employee details does Not exist for employeeId : "+ emp_id;
			}
	 }
			
	 @DeleteMapping("/employee")
	 public String deletAllEmployee() {
		 
		 employeeRepository.deleteAll();
	     return "all data deleted sucussfully ...";	 
	 }

     
////     
//	 @GetMapping("/employees/empcity")
//		public ResponseEntity<Employee> getEmployeeByempcity(@RequestParam("emp_city") String emp_city) {
//			Employee emp = employeeRepository.findByEmpcity(emp_city);
//			return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
//		}
//		
//		@GetMapping("/employee/employeeGreaterThan")
//		public ResponseEntity<List<Employee>> getEmployeeGreaterThan(@RequestParam("emp_age") int emp_age){
//			Optional<List<Employee>> empList = employeeRepository.findByEmpageGreaterThan(emp_age);
//			return new ResponseEntity<List<Employee>>(empList.get(), HttpStatus.FOUND);
//		}
	 
	 
}
