package com.blog.Blog_app_api.security;

import com.blog.Blog_app_api.entity.User;
import com.blog.Blog_app_api.exception.ResourceNotFoundException;
import com.blog.Blog_app_api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetail implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        loading user form database by username
        User user= this.userRepository.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","eamil"+username,0));

        return null;
    }
}
