package com.myblog.myblog.controller;

import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.payload.PostResponse;
import com.myblog.myblog.service.PostService;
import com.myblog.myblog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CRUD REST APIs for Post Resources")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(
            summary = "Create Post REST API",
            description = "Create Post REST API is used to save post into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/posts")
    private ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get All Posts REST API",
            description = "Get All Posts REST APIs is used to fetch all the posts from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/api/posts")
    private PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @Operation(
            summary = "Get Posts By Id REST API",
            description = "Get Posts By Id REST API is used to get single post from the database By Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/api/posts/{id}")
    private ResponseEntity<PostDto> getPostById(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Update Post REST API",
            description = "Update Post REST APIs is used to update a particular post in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/posts/{id}")
    private ResponseEntity<PostDto> updatePostById(@Valid @RequestBody PostDto postDto, @PathVariable long id){
        return new ResponseEntity<>(postService.updatePostById(postDto, id), HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Post REST API",
            description = "Delete Post REST APIs is used to delete a particular post from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/posts/{id}")
    private ResponseEntity<String> deletePostById(@PathVariable long id){
        return new ResponseEntity<>(postService.deletePostById(id), HttpStatus.OK);
    }
}
