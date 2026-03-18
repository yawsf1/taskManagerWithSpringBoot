package com.testing.task.user;


import com.testing.task.task.Task;
import com.testing.task.task.TaskRequest;
import com.testing.task.task.TaskResponse;
import com.testing.task.task.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TaskService taskService;
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @PostMapping
    public void addUser(@Valid @RequestBody UserRequest request){
        userService.addUser(request);
    }

    @GetMapping(path = "{id}")
    public UserResponse findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void modifyUser(@PathVariable Long id,@Valid @RequestBody UserRequest request){
        userService.modifyUser(id, request);
    }

    @GetMapping
    public List<UserResponse> findAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("{userId}/tasks")
    public void addTask(@PathVariable Long userId, @Valid @RequestBody TaskRequest request) {
        taskService.addTask(userId, request);
    }

    @GetMapping("{userId}/tasks")
    public List<TaskResponse> getUserTasks(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }
}
