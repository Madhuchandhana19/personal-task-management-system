package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;
@Service
public class TaskStatusLogService {
    @Autowired
    private TaskStatusLogRepository taskStatusRepo;

    public List<TaskStatusLog> getAllTaskStatusLogs(){
        return taskStatusRepo.findAll();
    }
}
