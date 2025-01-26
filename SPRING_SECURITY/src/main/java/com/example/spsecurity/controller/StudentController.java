package com.example.spsecurity.controller;

import com.example.spsecurity.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    List<Student> studentArrayList=new ArrayList<>(List.of(
            new Student(1,"ravi",35),
            new Student(2,"Visal",45)
    ));

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentArrayList;
    }
    @GetMapping("/csrf")
    public CsrfToken getcsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        studentArrayList.add(student);
        return student;
    }
}
