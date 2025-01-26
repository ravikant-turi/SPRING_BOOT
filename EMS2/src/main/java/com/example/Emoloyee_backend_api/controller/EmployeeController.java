package com.example.Emoloyee_backend_api.controller;

import com.example.Emoloyee_backend_api.dto.EmployeeDto;
import com.example.Emoloyee_backend_api.model.Employee;
import com.example.Emoloyee_backend_api.service.EmployeeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto>addEmployee(@Valid @RequestBody EmployeeDto employeeDto){
       EmployeeDto saveEmployee=this.employeeService.addEmployee(employeeDto);
       return new  ResponseEntity<>(saveEmployee, HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid  @RequestBody EmployeeDto employeeDto, @PathVariable Integer id){
        return new ResponseEntity<>(this.employeeService.updateEmployee(employeeDto,id),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable Integer id){
        return new ResponseEntity<>(this.employeeService.getEmployeeById(id),HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return new ResponseEntity<>(this.employeeService.getAllEmployee(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
    }


}
