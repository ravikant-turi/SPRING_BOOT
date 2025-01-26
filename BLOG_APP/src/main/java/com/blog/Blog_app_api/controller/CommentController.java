package com.blog.Blog_app_api.controller;

import com.blog.Blog_app_api.dto.CommentDto;
import com.blog.Blog_app_api.exception.ApiResponse;
import com.blog.Blog_app_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentDto> createCommentOnPost(@RequestBody CommentDto commentDto, @PathVariable Integer postId){

        CommentDto createComment=this.commentService.createComment(commentDto,postId);

        return new ResponseEntity<>(createComment, HttpStatus.CREATED);


    }
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<ApiResponse>deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("comment Deleted successfully",true),HttpStatus.OK);
    }

}
