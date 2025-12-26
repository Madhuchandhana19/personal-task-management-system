package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Task;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.repository.TaskStatusLogRepository;

@Service
public interface TaskStatusLogService {
    List<TaskStatusLog> getAllTaskStatusLogs();
    TaskStatusLog getStatusLogById(int id);
    TaskStatusLog addStatusLog(TaskStatusLog log, long taskId);
    List<TaskStatusLog> getLogsByTask(long taskId);
    List<TaskStatusLog> getLogsByOldStatus(String oldStatus);
    
    
} 