package com.testing.task.task;

import com.testing.task.user.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequest(
    @NotBlank(message = "La tache est obligatoire !")
    @Size(min = 3, max = 500, message = "La tache doit etre entre 3 et 500 characters")
    String task
) {}