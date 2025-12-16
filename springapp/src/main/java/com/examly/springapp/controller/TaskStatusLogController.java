package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;

@RestController
@RequestMapping("/api/taskstatuslogs")
public class TaskStatusLogController {
    @Autowired
    private TaskStatusLogRepository taskStatusLogRepository;

    @GetMapping
    public List<TaskStatusLog> getAllTaskStatusLog(){
        return taskStatusLogRepository.findAll();
    }
}
