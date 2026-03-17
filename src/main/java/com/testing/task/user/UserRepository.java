package com.testing.task.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /*
    Optional<User> findByNom(String nom);
    boolean existsByNom(String nom);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByAgeBetween(int min, int max);
    List<User> findByNomContaining(String keyword);

     */
}
