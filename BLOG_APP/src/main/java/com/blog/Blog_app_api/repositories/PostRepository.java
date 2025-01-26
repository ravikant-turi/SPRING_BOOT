package com.blog.Blog_app_api.repositories;

import com.blog.Blog_app_api.entity.Category;
import com.blog.Blog_app_api.entity.Post;
import com.blog.Blog_app_api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;


public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category );

    List<Post> findByTitleContaining(String title);



}
