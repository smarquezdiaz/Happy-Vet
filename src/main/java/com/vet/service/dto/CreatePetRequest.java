package com.vet.service.dto;

import java.time.LocalDate;

public record CreatePetRequest(
        Long ownerId,
        String name,
        String specie,
        String breed,
        String sex,
        LocalDate birthDate,
        String color,
        String observations
) {
}
