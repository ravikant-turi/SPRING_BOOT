package com.blog.Blog_app_api.controller;

import com.blog.Blog_app_api.configure.AppConstants;
import com.blog.Blog_app_api.dto.PostDto;
import com.blog.Blog_app_api.dto.PostResponse;
import com.blog.Blog_app_api.entity.Post;
import com.blog.Blog_app_api.exception.ApiResponse;
import com.blog.Blog_app_api.service.FileService;
import com.blog.Blog_app_api.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private  String path;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto
    , @PathVariable Integer userId,@PathVariable Integer categoryId){

        PostDto createPost=this.postService.createPost(postDto,userId,categoryId );

        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}/post")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId ){
        PostDto postDto=this.postService.getPostById(postId);

        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }
//    get By Category
    @GetMapping("/category/{categoryId}/post")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
      List<PostDto>list =this.postService.getPostsByCategory(categoryId);
      return new ResponseEntity<>(list,HttpStatus.OK);
    }

//    get By user
    @GetMapping("/user/{userId}/post")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
       List<PostDto>postDtoList = this.postService.getPostByUser(userId);

       return new ResponseEntity<>(postDtoList,HttpStatus.OK);
    }
//    / get all user/6:34:30
    @GetMapping("/posts")
    public ResponseEntity<PostResponse>getAllPost(
            @RequestParam(value = "pageNumber",defaultValue= AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue =AppConstants.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue =AppConstants.SORT_BY,required = false)String sortBy,
            @RequestParam(value = "sortDir",defaultValue =AppConstants.SORT_DIR,required = false) String sortDir

    ) {

       PostResponse postResponse=this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);

        return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);


    }
    @GetMapping("/getAllPost")
    public ResponseEntity<List<PostDto>>getAllPostAll(){
        List<PostDto> allPosts=this.postService.getAllPostAll();
        return new ResponseEntity<>(allPosts,HttpStatus.OK);
    }
//    delete post by id
    @DeleteMapping("/{postId}/post")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
       this.postService.deletePost(postId);

       return new  ResponseEntity<>(new ApiResponse("post Deleted successfully",true),HttpStatus.OK);
    }

//    update Post
    @PutMapping("/{postId}/post")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable Integer postId){
       PostDto updatedPost= this.postService.updatePost(postDto,postId);
       return  new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

//    search post by title
    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchByTitle(@PathVariable String keyword
    ){
       List<PostDto>list=this.postService.searchPosts(keyword);
       return new ResponseEntity<>(list,HttpStatus.OK);
    }


//    postImage upload

    @PostMapping("/post/image/upload/{postId}")
    public  ResponseEntity<PostDto>uploadPostImage(
            @RequestParam("image")MultipartFile image,
            @PathVariable Integer postId
            ) throws IOException {
        PostDto postDto=this.postService.getPostById(postId);
        String fileName=this.fileService.uploadImage(path,image);
        postDto.setImageName(fileName);
        PostDto updatePost=this.postService.updatePost(postDto,postId);

        return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }


//    method to serve files
//    @GetMapping(value ="/post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
//    public void downloadImage(@PathVariable("imageName") String imageName,
//                              HttpServletResponse response
//    ) throws IOException {
//    InputStream resource=this.fileService.getResource(path,imageName);
//    resource.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(resource,response.getOutputStream());
//    }



}
