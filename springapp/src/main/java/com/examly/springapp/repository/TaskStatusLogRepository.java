package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.model.TaskStatusLog;

@Repository
public interface TaskStatusLogRepository extends JpaRepository<TaskStatusLog,Integer> {
    List<TaskStatusLog> findByTaskIdTaskId(long taskId);
    List<TaskStatusLog> findByOldStatus(String oldStatus);
    


    @Query("SELECT ta FROM TaskAssignment ta WHERE ta.taskId = :userId")
    List<TaskAssignment> findByUserId(int userId);

}
