package com.testing.task.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    /*
    List<Task> findByTaskContaining(String keyword);
    int countByUserId(Long userId);
    boolean existsByUserIdAndTask(Long userId, String task);
    void deleteByUserId(Long userId);
     */
}
