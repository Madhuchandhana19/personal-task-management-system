package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Comment;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.CommentRepository;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        commentRepository.save(comment);
        return comment;
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable int id ){
        return commentRepository.findById(id).orElse(null);
    }
    

}
