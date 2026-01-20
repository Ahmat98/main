package com.myblog.myblog.service;

import com.myblog.myblog.payload.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentByPostIdAndCommentId(long postId, long commentId);
    CommentDto updateCommentById(long postId, long commentId, CommentDto commentDto);

    void deleteCommentById(long postId, long commentId);
}
