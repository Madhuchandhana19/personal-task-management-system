package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Task;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;
import com.examly.springapp.service.TaskService;
import com.examly.springapp.service.TaskStatusLogService;

@RestController
@RequestMapping("/api/status-logs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogService taskStatusLogService;
    @Autowired
    private TaskStatusLogRepository taskStatusRepo;

    @Autowired
    TaskService taskService;
    @PostMapping
    public ResponseEntity<TaskStatusLog> addStatusLog(@RequestBody TaskStatusLog log) {

        if (log == null || log.getTaskId() == null) {
            return ResponseEntity.badRequest().build();
        }

        TaskStatusLog saved =
                taskStatusLogService.addStatusLog(log, log.getTaskId().getTaskId());

        if (saved == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @GetMapping 
    public ResponseEntity<List<TaskStatusLog>> getAllStatusLogs() {

    List<TaskStatusLog> logs = taskStatusLogService.getAllTaskStatusLogs();

    if (logs.isEmpty()) {
        return ResponseEntity.noContent().build();
    }

    return new ResponseEntity<>(logs, HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<TaskStatusLog> getStatusLogById(@PathVariable int id) {

    TaskStatusLog log = taskStatusLogService.getStatusLogById(id);

    if (log == null) {
        return ResponseEntity.notFound().build();
    }

    return new ResponseEntity<>(log, HttpStatus.OK);
}
@GetMapping("/task/{taskId}")
public ResponseEntity<List<TaskStatusLog>> getLogsByTask(@PathVariable long taskId) {

    List<TaskStatusLog> logs = taskStatusLogService.getLogsByTask(taskId);

    if (logs.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    return new ResponseEntity<>(logs, HttpStatus.OK);
}
@GetMapping("/old/{oldStatus}")
public ResponseEntity<?> getLogsByOldStatus(@PathVariable String oldStatus) {

    List<TaskStatusLog> logs = taskStatusLogService.getLogsByOldStatus(oldStatus);

    if (logs == null || logs.isEmpty()) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("No logs found with oldStatus: " + oldStatus);
    }

    return ResponseEntity.ok(logs);
}








}