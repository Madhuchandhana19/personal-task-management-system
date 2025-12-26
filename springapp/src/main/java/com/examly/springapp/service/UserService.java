package com.examly.springapp.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(long id, User user);
    List<User> getUsersByRole(String role);
    Page<User> getUsersWithPagination(int page, int size);
}