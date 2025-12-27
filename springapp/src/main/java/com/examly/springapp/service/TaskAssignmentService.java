package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Task;
import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;
@Service
public interface TaskAssignmentService {
    List<TaskAssignment> getAllTaskAssignments();
    List<TaskAssignment> getAssignmentsByUserId(int userId);
    TaskAssignment creTaskAssignment(TaskAssignment assi);
    


}
