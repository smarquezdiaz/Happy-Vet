package com.vet.service.dto;

import java.time.LocalDate;

public record PetResponse(
        Long id,
        String name,
        String specie,
        String breed,
        String sex,
        LocalDate birthDate,
        String color,
        String observations
) {
}
