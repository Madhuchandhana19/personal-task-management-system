package com.examly.springapp.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class TaskStatusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusLogId;

    @ManyToOne
    private Task taskId;

    private String oldStatus;
    private String newStatus;
    private Date changeDate;
    
    public Task getTask() {
    return this.taskId;
    }

    @JsonProperty("task")
    public void setTask(Task task) {
        this.taskId = task;
    }
    public int getId() {
        return this.statusLogId;
    }

    public TaskStatusLog() {
    }

    public TaskStatusLog(int statusLogId, Task taskId, String oldStatus, String newStatus, Date changeDate) {
        this.statusLogId = statusLogId;
        this.taskId = taskId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.changeDate = changeDate;
    }

    public int getStatusLogId() {
        return statusLogId;
    }

    public void setStatusLogId(int statusLogId) {
        this.statusLogId = statusLogId;
    }

    public Task getTaskId() {
        return taskId;
    }

    public void setTaskId(Task taskId) {
        this.taskId = taskId;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}