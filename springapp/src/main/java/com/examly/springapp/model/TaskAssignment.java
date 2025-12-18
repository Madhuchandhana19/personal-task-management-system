package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TaskAssignment {

    @Id
    private int taskId;

    public TaskAssignment() {
    }

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