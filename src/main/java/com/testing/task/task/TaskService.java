package com.testing.task.task;

import com.testing.task.user.User;
import com.testing.task.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Long userId, Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);
        taskRepository.save(task);
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
    public void modifyTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setTask(task.getTask());
        taskRepository.save(existingTask);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }
}