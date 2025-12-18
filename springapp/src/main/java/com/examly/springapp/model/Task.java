package com.examly.springapp.model;

import java.util.Date;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Task {
    
public long getId() {
    return this.taskId;
}

@JsonProperty("id")
public void setId(long id) {
    this.taskId = id;
}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    private String title;
    private String description;
    private String status;
    private String priority;
    private Date dueDate;

    @ManyToOne
    private User assignedTo;

    public Task() {
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
}