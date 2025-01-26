package com.blog.Blog_app_api.configure;

import com.blog.Blog_app_api.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configuration.;


@Configuration
@EnableWebSecurity
public class SecurityConfig   {

    @Autowired
    private CustomUserDetailService customUserDetailService;

@Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
    return    http
              .csrf(Customizer.withDefaults())
              .authorizeHttpRequests((auth)->
                      auth.anyRequest().authenticated())
              .httpBasic(Customizer.withDefaults())
              .build();

      }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        provider.setUserDetailsService(customUserDetailService);
//        return provider;
//    }

//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//           auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    private BCryptPasswordEncoder passwordEncoder(){
//      return new BCryptPasswordEncoder();
//    }


}



