package com.example.spsecurity.filter;

import com.example.spsecurity.service.JwtService;
import com.example.spsecurity.service.MyUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;


@Component
public class JwtFileter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService ;
    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader=request.getHeader("Authorization");

        String token=null;

        String username=null;
        System.out.println("authHeader is :" + authHeader);

        if (authHeader!=null && authHeader.startsWith("Bearer ")){
            token =authHeader.substring(7);
            username=jwtService.extractUserName(token);

        }
        System.out.println(" Now , token : " + token);
        System.out.println("username : "+ username);
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails userDetails=context.getBean(MyUserDetailService.class).loadUserByUsername(username);
            if (jwtService.validatetoken(token,userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
