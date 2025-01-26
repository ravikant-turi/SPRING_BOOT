package com.blog.Blog_app_api.service;

import com.blog.Blog_app_api.dto.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Integer commentId);
}
