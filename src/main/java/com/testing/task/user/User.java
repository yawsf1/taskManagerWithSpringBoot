package com.testing.task.user;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.testing.task.task.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nom doit est obligatoire")
    @Size(min = 3, max = 500, message = "Nom doit etre entre 3 et 500")
    private String nom;

    @Min(value = 18, message = "l'age doit etre superieur a 18")
    @Max(value = 140, message = "Invalid age")
    private int age;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User(Long id, int age, String nom) {
        this.id = id;
        this.age = age;
        this.nom = nom;
    }

    public User() {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(nom, user.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, age);
    }
}
