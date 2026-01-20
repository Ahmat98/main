package com.myblog.myblog.service;

import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.payload.PostResponse;



public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePostById(PostDto postDto, long id);
    String deletePostById(long id);
}
