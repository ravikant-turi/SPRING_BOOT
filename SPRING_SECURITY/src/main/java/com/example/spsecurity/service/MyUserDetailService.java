package com.example.spsecurity.service;

import com.example.spsecurity.entity.UserPrincipal;
import com.example.spsecurity.entity.Users;
import com.example.spsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
   @Autowired
    private  UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=this.userRepo.findByName(username);
        if (user==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found Exception");
        }

        return new UserPrincipal(user);
    }

}
