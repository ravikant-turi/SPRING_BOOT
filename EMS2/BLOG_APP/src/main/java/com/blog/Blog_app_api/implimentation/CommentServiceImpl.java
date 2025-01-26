package com.blog.Blog_app_api.implimentation;

import com.blog.Blog_app_api.dto.CommentDto;
import com.blog.Blog_app_api.dto.PostDto;
import com.blog.Blog_app_api.dto.PostResponse;
import com.blog.Blog_app_api.entity.Comment;
import com.blog.Blog_app_api.entity.Post;
import com.blog.Blog_app_api.exception.ResourceNotFoundException;
import com.blog.Blog_app_api.repositories.CommentRepo;
import com.blog.Blog_app_api.repositories.PostRepository;
import com.blog.Blog_app_api.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
        this.commentRepo.delete(com);
    }
}
