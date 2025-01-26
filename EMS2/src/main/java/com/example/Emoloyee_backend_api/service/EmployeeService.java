package com.example.Emoloyee_backend_api.service;

import com.example.Emoloyee_backend_api.dto.EmployeeDto;
import com.example.Emoloyee_backend_api.exception.ResourceNotFoundException;
import com.example.Emoloyee_backend_api.mapper.EmployeeMapper;
import com.example.Emoloyee_backend_api.model.Employee;
import com.example.Emoloyee_backend_api.repo.EmployeeRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        Employee employee=EmployeeDtoToEmployee(employeeDto);

        Employee saveEmployee= this.employeeRepo.save(employee);
        return  EmployeeToEmployeeDot(saveEmployee);

    }
    public Employee EmployeeDtoToEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setEmployeeId(employeeDto.getId());
        employee.setEmployeeName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
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


    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee=this.employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found at this id"+ id));
        return this.EmployeeToEmployeeDot(employee);
    }

    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList=this.employeeRepo.findAll();
       return employeeList.stream().map((this::EmployeeToEmployeeDot)).collect(Collectors.toList());

    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto,Integer id) {
        Employee employee= EmployeeDtoToEmployee(employeeDto);
        Employee getEmployee=this.employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not found"));
        getEmployee.setSalary(employee.getSalary());
        getEmployee.setEmployeeName(employee.getEmployeeName());
        getEmployee.setEmail(employee.getEmail());
        Employee updatedEmployee=this.employeeRepo.save(getEmployee);
        return EmployeeToEmployeeDot(updatedEmployee);
    }

    public void deleteEmployee(Integer id) {
       Employee employee= this.employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee doesnot exit"));
        this.employeeRepo.delete(employee);
    }
}
