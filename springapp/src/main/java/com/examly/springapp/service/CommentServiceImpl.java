package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService  {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int id) {
        return commentRepository.findById(id).orElse(null);
    }
    public Comment getAllComments(Comment comment){
        return commentRepository.save(comment);
    }
   
}
