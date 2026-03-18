package com.testing.task.user;

import jakarta.validation.constraints.*;

public record UserRequest(
        @NotBlank(message = "Le nom est obligatoire")
        @Size(min = 3, max = 500, message = "Le nom doit être entre 3 et 500 caractères")
        String nom,

        @Min(value = 18, message = "L'âge doit être supérieur à 18")
        @Max(value = 140, message = "L'âge est invalide")
        int age
) {}
