package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Task;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.service.TaskService;
import com.examly.springapp.service.TaskStatusLogService;

@RestController
@RequestMapping("/api/taskstatuslogs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogService taskStatusLogService;

    @Autowired
    TaskService taskService;
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
    List<Task> tasks = taskService.getAllTasks();
    if (tasks.isEmpty()) {
        return ResponseEntity.noContent().build(); 
    }
    return new ResponseEntity<>(tasks, HttpStatus.OK); 
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable long id) {

    Task task = taskService.getTaskById(id);

    if (task == null) {
        return new ResponseEntity<>(
            "Task not found with id " + id,
            HttpStatus.NOT_FOUND
        ); 
    }

    return new ResponseEntity<>(task, HttpStatus.OK); 
}





}