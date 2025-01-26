package com.blog.Blog_app_api.service;

import com.blog.Blog_app_api.dto.UserDto;

import java.util.List;


public interface UserService {

//    UserDto registerNewUser(UserDto user);


    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();



    void deleteUser(Integer userId);

}