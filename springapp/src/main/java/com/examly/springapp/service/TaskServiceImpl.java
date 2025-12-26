package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService  {
    @Autowired
    private TaskRepository taskRepo;

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task task) {
        task.setTaskId(id);
        return taskRepo.save(task);
    }
    public Task updateTaskStatus(long id, String status) {
    Task task = getTaskById(id);   
    if (task == null) return null;
    task.setStatus(status);
    return taskRepo.save(task);
}


    public boolean deleteTaskById(Long id) {
        if (taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Task> getTasksByUser(long userId) {
    return taskRepo.findByAssignedTo_UserId(userId);
}
    public List<Task> getTasksByStatus(String status) {
    return taskRepo.findByStatus(status);
    }
}
