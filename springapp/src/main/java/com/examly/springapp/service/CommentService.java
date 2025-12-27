package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@Service
public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(int id);
    Comment getAllComments(Comment comment);

    
}