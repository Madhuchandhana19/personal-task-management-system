package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public Task createTask(@RequestBody Task task){
        taskRepository.save(task);
        return task;
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id){
        return taskRepository.findById(id)
        .map(task -> new ResponseEntity<>(task,HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task){
        task.setTaskId(id);
        taskRepository.save(task);
        return task;
    }

    @DeleteMapping("/api/tasks/{id}")
    public void deleteTask(@PathVariable long id){
        taskRepository.deleteById(id);
    }
    
}
