package com.myblog.myblog.controller;

import com.myblog.myblog.entity.Comment;
import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{post_id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "post_id") long postId, @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentByPostIdAndCommentId(@PathVariable(value = "postId") long postId,
                                                                     @PathVariable(value = "commentId") long commentId){
        return new ResponseEntity<>(commentService.getCommentByPostIdAndCommentId(postId, commentId), HttpStatus.OK);
    }


    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable(value = "postId") long postId,
                                                        @PathVariable(value = "commentId") long commentId,
                                                        @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.updateCommentById(postId, commentId, commentDto), HttpStatus.OK);
    }


    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String>  deleteCommentById(@PathVariable(value = "postId") long postId,
                                                     @PathVariable(value = "commentId") long commentId){
        commentService.deleteCommentById(postId, commentId);
        return new ResponseEntity<>( "Comment deleted successfully", HttpStatus.OK);
    }
}
