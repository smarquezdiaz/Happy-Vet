package com.vet.service;

import com.vet.persistence.entity.PetEntity;
import com.vet.service.dto.CreatePetRequest;
import com.vet.service.dto.PetResponse;
import com.vet.service.dto.UpdatePetRequest;

import java.util.List;

public interface PetService {
    List<PetResponse> getAll();

    PetResponse getById(Long petId);

    PetResponse save(CreatePetRequest createPetRequest);

    PetResponse update(UpdatePetRequest updatePetRequest, Long id);

    void delete(Long id);

    boolean exists(Long id);
}
