package com.blog.Blog_app_api.repositories;

import com.blog.Blog_app_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//@Repository
//@Service
public interface UserRepository extends JpaRepository<User,Integer> {
  Optional<User> findByEmail(String emaail);


}
