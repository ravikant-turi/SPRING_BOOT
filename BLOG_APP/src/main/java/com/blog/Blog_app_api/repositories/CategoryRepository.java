package com.blog.Blog_app_api.repositories;

import com.blog.Blog_app_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
