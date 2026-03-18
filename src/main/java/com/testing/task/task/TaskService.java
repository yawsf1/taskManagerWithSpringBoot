package com.testing.task.task;

import com.testing.task.exception.ApiRequestException;
import com.testing.task.exception.ResourceNotFoundException;
import com.testing.task.user.User;
import com.testing.task.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskDTOMapper taskDTOMapper;

    TaskService(TaskRepository taskRepository, UserRepository userRepository, TaskDTOMapper taskDTOMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskDTOMapper = taskDTOMapper;
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskDTOMapper).collect(Collectors.toList());
    }

    public void addTask(Long userId, TaskRequest task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Task realTask = taskDTOMapper.toEntity(task);
        realTask.setUser(user);
        taskRepository.save(realTask);
    }
    public TaskResponse getTaskById(Long id) {
        return taskRepository.findById(id).map(taskDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
    public void modifyTask(Long id, TaskRequest task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        Task realTask = taskDTOMapper.toEntity(task);
        existingTask.setTask(realTask.getTask());
        taskRepository.save(existingTask);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public List<TaskResponse> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId).stream().map(taskDTOMapper).collect(Collectors.toList());
    }
}