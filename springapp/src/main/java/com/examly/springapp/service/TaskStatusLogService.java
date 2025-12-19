package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Task;
import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.repository.TaskStatusLogRepository;

@Service
public class TaskStatusLogService {

    @Autowired
    private TaskStatusLogRepository taskStatusRepo;
    @Autowired
    private TaskRepository taskRepo;

    
    public List<TaskStatusLog> getAllTaskStatusLogs() {
        return taskStatusRepo.findAll();
    }
    public TaskStatusLog getStatusLogById(int id) {
        return taskStatusRepo.findById(id).orElse(null);
    }
    public TaskStatusLog addStatusLog(TaskStatusLog log, long taskId) {
        Task task = taskRepo.findById(taskId).orElse(null);
        if (task == null) return null;

        log.setTaskId(task);
        return taskStatusRepo.save(log);
    }

    public List<TaskStatusLog> getLogsByTask(long taskId) {
        return taskStatusRepo.findByTaskIdTaskId(taskId);
    }
    public List<TaskStatusLog> getLogsByOldStatus(String oldStatus) {
        return taskStatusRepo.findByOldStatus(oldStatus);
    }


}
