package com.example.EmployeeManagementSystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//	Employee findByEmpcity(String emp_city);
//
//	Optional<List<Employee>> findByEmpageGreaterThan(int emp_age);
}
