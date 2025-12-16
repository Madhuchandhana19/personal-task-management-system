package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;

@RestController
@RequestMapping("/api/taskassignments")
public class TaskAssignmentController {
    @Autowired
    private TaskAssignmentRepository taskAssignmentRepository;

    @PostMapping
    public TaskAssignment createTaskAssignment(@RequestBody TaskAssignment taskAssignment){
        taskAssignmentRepository.save(taskAssignment);
        return taskAssignment;
    }
    @GetMapping
    public List<TaskAssignment> getAllTaskAssignments(){
        return taskAssignmentRepository.findAll();
    }
}
