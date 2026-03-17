package com.testing.task.user;


import com.testing.task.task.Task;
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
    public void addUser(@Valid @RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping(path = "{id}")
    public User findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void modifyUser(@PathVariable Long id,@Valid @RequestBody User user){
        userService.modifyUser(id, user);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("{userId}/tasks")
    public void addTask(@PathVariable Long userId, @Valid @RequestBody Task task) {
        taskService.addTask(userId, task);
    }

    @GetMapping("{userId}/tasks")
    public List<Task> getUserTasks(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }
}
