package com.example.Emoloyee_backend_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;

public class EmployeeDto {
    private  Integer id;

    @NotEmpty
    @NotNull(message = "Name is mandatory")
    private String name;

    @Email(message = "Enter valid email")
    @NotNull(message = "enter a email")
    @NotEmpty

    private String email;
    @NotNull( message = "salary  is mandatory")
    @Min(value = 1000 , message ="salary must be more than 1000")
    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
