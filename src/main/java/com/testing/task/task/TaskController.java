package com.testing.task.task;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping(path = "{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }
    @DeleteMapping(path = "{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
    @PutMapping(path = "{id}")
    public void updateTask(@PathVariable Long id, @Valid @RequestBody Task task){
        taskService.modifyTask(id, task);
    }
}
