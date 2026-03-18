package com.testing.task.task;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TaskDTOMapper implements Function<Task, TaskResponse> {
    // entity → response (used with .stream().map(taskMapper))
    @Override
    public TaskResponse apply(Task task) {
        return new TaskResponse(task.getId(), task.getTask());
    }

    public Task toEntity(TaskRequest request) {
        Task task = new Task();
        task.setTask(request.task());
        return task;
    }
}
