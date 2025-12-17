package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.service.TaskStatusLogService;

@RestController

@RequestMapping("/api/taskstatuslogs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogService taskStatusLogService;

    @GetMapping
    public ResponseEntity<List<TaskStatusLog>> getAllStatusLogs() {
        List<TaskStatusLog> logs = taskStatusLogService.getAllTaskStatusLogs();
        if (logs.isEmpty()) {
            return new ResponseEntity<>(logs,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
