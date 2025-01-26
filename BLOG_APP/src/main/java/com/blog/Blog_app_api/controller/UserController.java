package com.blog.Blog_app_api.controller;


import com.blog.Blog_app_api.exception.ApiResponse;
import com.blog.Blog_app_api.dto.UserDto;

import com.blog.Blog_app_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {


    @Autowired
    private UserService userService;



   //    post - create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto= this.userService.createUser(userDto);

        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

    }
    //    put - update user

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto > updateUser(@Valid @RequestBody UserDto userDto,
                                               @PathVariable("userId") Integer userId){

        UserDto updatedUser=this.userService.updateUser(userDto,userId);
        return  new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }




   //    delete - delete user

    @DeleteMapping( "/{userId}" )
    public ResponseEntity<ApiResponse > deleteUser( @PathVariable("userId") Integer userId  ){

        this.userService.deleteUser(userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse(" User deleted successfully",true),HttpStatus.OK);
    }

//     get - user get

    @GetMapping("/{id}")
    public ResponseEntity<UserDto>getSingleUser(@PathVariable("id")Integer userId){

        UserDto user=this.userService.getUserById(userId);

        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>>getAllUser(){
        List<UserDto>user=this.userService.getAllUsers();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
