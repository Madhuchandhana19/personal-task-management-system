package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {
    @Autowired
    private TaskAssignmentRepository taskRepo;

    public List<TaskAssignment> getAllTaskAssignments(){
        return taskRepo.findAll();

    }
    public List<TaskAssignment> getAssignmentsByUserId(int userId) {
        return taskRepo.findAll();
    }
    public TaskAssignment creTaskAssignment(TaskAssignment assi){
        return taskRepo.save(assi);
    }
   
}
