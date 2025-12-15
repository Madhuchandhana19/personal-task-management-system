package com.examly.springapp.model;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    private long taskId;
    private String title;
    private String description;
    private String status;
    private String priority;
    private date dueDate;
    

}
