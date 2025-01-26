package com.example.spsecurity.service;

import com.example.spsecurity.entity.Users;
import com.example.spsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public Users register(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return this.userRepo.save(users);
    }

    public String verify(Users users) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getName(),users.getPassword()));
       if( authentication.isAuthenticated()) {
           return jwtService.generateToken(users.getName());
//           return  "success";
       }
       return "fails";
    }
}
