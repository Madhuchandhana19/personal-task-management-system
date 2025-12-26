package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public interface TaskService {
    List<Task> getAllTasks();
    Task createTask(Task task) ;
    Task getTaskById(Long id);
    Task updateTask(Long id, Task task) ;
    Task updateTaskStatus(long id, String status);
    boolean deleteTaskById(Long id);
    List<Task> getTasksByUser(long userId);
    List<Task> getTasksByStatus(String status);
}