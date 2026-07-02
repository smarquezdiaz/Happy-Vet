package com.vet.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdatePetRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Specie is required")
        String specie,

        String breed,

        @NotBlank(message = "Sex is required")
        String sex,

        @PastOrPresent(message = "Birth date cannot be in the future")
        LocalDate birthDate,

        String color,

        String observations
) {
}
