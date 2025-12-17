package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.service.TaskAssignmentService;

@RestController
@RequestMapping("/api/taskassignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    

    @GetMapping
    public ResponseEntity<List<TaskAssignment>> getAllTaskAssignments() {
        List<TaskAssignment> tasks = taskAssignmentService.getAllTaskAssignments();
        if (tasks.size()>0) {
            return new ResponseEntity <>(tasks,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
