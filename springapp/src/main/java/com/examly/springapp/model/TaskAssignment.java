package com.examly.springapp.model;

import jakarta.persistence.Id;

public class TaskAssignment {

    public TaskAssignment() {
    }
    @Id
    private int taskId;
    public TaskAssignment(int taskId) {
        this.taskId = taskId;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
}
