package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    private int commentId;

    public Comment() {
    }

    public Comment(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}