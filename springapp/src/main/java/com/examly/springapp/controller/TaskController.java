package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if (task == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Task> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
public ResponseEntity<String> getTaskById(@PathVariable long id) {

    Task task = taskService.getTaskById(id);

    if (task == null) {
        return new ResponseEntity<>(
            "Task not found with id " + id,
            HttpStatus.NOT_FOUND
        );
    }

    return new ResponseEntity<>(task.toString(), HttpStatus.OK);
}


    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id,
            @RequestBody Task task) {

        if (task == null) {
            return ResponseEntity.badRequest().build();
        }

        Task updated = taskService.updateTask(id, task);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        boolean deleted = taskService.deleteTaskById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}
