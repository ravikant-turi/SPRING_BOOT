package com.example.spsecurity.controller;

import com.example.spsecurity.entity.Users;
import com.example.spsecurity.repo.UserRepo;
import com.example.spsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users){
        return  this.userService.register(users);

    }
    @PostMapping("/login")
    public String login(@RequestBody Users users){
        System.out.println(users);
        return this.userService.verify(users);
    }

}
