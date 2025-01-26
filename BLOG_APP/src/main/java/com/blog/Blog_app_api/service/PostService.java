package com.blog.Blog_app_api.service;

import com.blog.Blog_app_api.dto.PostDto;
import com.blog.Blog_app_api.dto.PostResponse;
import com.blog.Blog_app_api.entity.Category;
import com.blog.Blog_app_api.entity.Post;

import java.util.List;

public interface PostService {


//    create
    PostDto createPost(PostDto postDto, Integer userID, Integer categoryId);

//    update
    PostDto updatePost(PostDto postDto,Integer postId);

//    delete
    void deletePost(Integer postId);

//    get all Posts
    PostResponse getAllPost(Integer pageNumber , Integer pageSize,String sortBy,String sortDir);
//    get all posts
    List<PostDto>getAllPostAll();

//    get one post
    PostDto getPostById(Integer postId);

//    get all Post by category

    List<PostDto> getPostsByCategory(Integer categoryId);

//    search posts
    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);



}
