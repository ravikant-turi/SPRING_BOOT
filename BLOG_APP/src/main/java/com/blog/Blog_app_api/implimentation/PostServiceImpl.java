package com.blog.Blog_app_api.implimentation;
import com.blog.Blog_app_api.dto.PostDto;
import com.blog.Blog_app_api.dto.PostResponse;
import com.blog.Blog_app_api.entity.Category;
import com.blog.Blog_app_api.entity.Post;
import com.blog.Blog_app_api.entity.User;
import com.blog.Blog_app_api.exception.ResourceNotFoundException;
import com.blog.Blog_app_api.repositories.CategoryRepository;
import com.blog.Blog_app_api.repositories.PostRepository;
import com.blog.Blog_app_api.repositories.UserRepository;
import com.blog.Blog_app_api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepository.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

//        post.setPostId(postDto.getPostId());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setUser(postDto.getUser());
        post.setCategory(postDto.getCategory());
        post.setAddedDate(new Date());
        post.setImageName(postDto.getImageName());

        Post updatedUser = this.postRepository.save(post);
        return this.modelMapper.map(updatedUser, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        this.postRepository.delete(post);

    }

    @Override
    public PostResponse getAllPost(Integer PageNumber, Integer PageSize,String sortBy,String sortDir) {
        Sort sort=null;
        if (sortDir.equalsIgnoreCase("asc")){
            sort=Sort.by(sortBy).ascending();
        }
        else {
            sort=Sort.by(sortBy).descending();
        }
        Pageable pageable = PageRequest.of(PageNumber, PageSize,sort);

        Page<Post> pagePost = this.postRepository.findAll(pageable);

        List<Post> posts = pagePost.getContent();

        List<PostDto> postDtos = posts.stream().map((post -> this.modelMapper.map(post, PostDto.class))).collect(Collectors.toList());


    PostResponse postResponse = new PostResponse();

    postResponse.setContent(postDtos);
    postResponse.setPageNumber(pagePost.getNumber());
    postResponse.setPageSize(pagePost.getSize());
    postResponse.setTotalElement(pagePost.getTotalElements());
    postResponse.setTotalPages(pagePost.getTotalPages());
    postResponse.setLastPage(pagePost.isLast());

     return postResponse;
}
    @Override
    public List<PostDto> getAllPostAll() {
        List<Post> allPost=this.postRepository.findAll();

        return allPost.stream().map((post -> this.modelMapper.map(post,PostDto.class))).collect(Collectors.toList());
    }


    @Override
    public PostDto getPostById(Integer postId) {

        Post post=this.postRepository.findById(postId).orElseThrow(()->
            new ResourceNotFoundException("Post","PostId",postId)
        );

        return this.modelMapper.map(post,PostDto.class);

    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {

        Category category=this.categoryRepository.findById(categoryId).orElseThrow(
                 ()->new ResourceNotFoundException("Category","categoryId",categoryId));

        List<Post>postList=this.postRepository.findByCategory(category);

       return    postList.stream().map((post -> this.modelMapper.map(post,PostDto.class))).collect(Collectors.toList());

//return null;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {

        User user=this.userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","userId",userId));

       List<Post> postList= this.postRepository.findByUser(user);

      return postList.stream().map((post -> this.modelMapper.map(post,PostDto.class))).collect(Collectors.toList());

//        return null;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
       List<Post> postList=this.postRepository.findByTitleContaining(keyword);
        return postList.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());

    }


}
