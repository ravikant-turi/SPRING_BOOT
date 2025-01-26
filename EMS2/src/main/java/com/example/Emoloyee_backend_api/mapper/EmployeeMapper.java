package com.example.Emoloyee_backend_api.mapper;

import com.example.Emoloyee_backend_api.dto.EmployeeDto;
import com.example.Emoloyee_backend_api.model.Employee;

public class EmployeeMapper {
    public Employee EmployeeDtoToEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setEmployeeId(employeeDto.getId());
        employee.setEmployeeName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }
    public  EmployeeDto EmployeeToEmployeeDot(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setId(employee.getEmployeeId());
        employeeDto.setName(employee.getEmployeeName());
        employeeDto.setSalary(employee.getSalary());
        return employeeDto;
    }
}
