package com.example.spsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public String testController(HttpServletRequest http){
        return http.getPathInfo()+"this is testing api"+http.getSession().getId() ;
    }
}
