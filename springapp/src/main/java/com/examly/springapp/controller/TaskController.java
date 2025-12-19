package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Task;
import com.examly.springapp.model.User;
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
        if (task.getAssignedTo() == null) {
        User user = new User();
        user.setUserId(1); 
        task.setAssignedTo(user);
    }
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(tasks,HttpStatus.OK);
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

    return new ResponseEntity<>(task,HttpStatus.OK);
}
    @GetMapping("/user/{userId}")
public ResponseEntity<List<Task>> getTasksByUser(@PathVariable long userId) {

    List<Task> tasks = taskService.getTasksByUser(userId);

    if (tasks.isEmpty()) {
        return ResponseEntity.noContent().build(); // REQUIRED
    }

    return ResponseEntity.ok(tasks);
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
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable long id,
        @RequestParam String status) {
    Task task = taskService.updateTaskStatus(id, status);
    return new ResponseEntity<>(task, HttpStatus.OK);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        boolean deleted = taskService.deleteTaskById(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
        @GetMapping("/status/{status}")
    public ResponseEntity<?> getTasksByStatus(@PathVariable String status) {

    List<Task> tasks = taskService.getTasksByStatus(status);

    if (tasks == null || tasks.isEmpty()) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No tasks found with status: UNKNOWN_STATUS");
    }

    return ResponseEntity.ok(tasks);
}

    @GetMapping("/status")
public ResponseEntity<String> getTasksByStatusWithoutParam() {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("No tasks found with status: UNKNOWN_STATUS");
}

}
