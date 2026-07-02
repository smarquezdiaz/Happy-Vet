package com.vet.service.impl;

import com.vet.persistence.entity.PetEntity;
import com.vet.persistence.mapper.PetMapper;
import com.vet.persistence.repository.PetRepository;
import com.vet.service.PetService;
import com.vet.service.dto.CreatePetRequest;
import com.vet.service.dto.PetResponse;
import com.vet.service.dto.UpdatePetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    @Override
    public List<PetResponse> getAll() {
        return this.petMapper.toDto(this.petRepository.findAll());
    }

    @Override
    public PetResponse getById(Long petId) {
        PetEntity petEntity = this.petRepository.findById(petId).orElse(null);
        return this.petMapper.toDto(petEntity);
    }

    @Override
    public PetResponse save(CreatePetRequest createPetRequest) {
        PetEntity petEntity = this.petMapper.toEntity(createPetRequest);
        return this.petMapper.toDto(this.petRepository.save(petEntity));
    }

    @Override
    public PetResponse update(UpdatePetRequest updatePetRequest, Long id) {
        PetEntity petEntity = this.petRepository.findById(id).orElse(null);

        if (petEntity == null) {
            return null;
        }

        this.petMapper.updateEntityFromDto(updatePetRequest, petEntity);

        return this.petMapper.toDto(this.petRepository.save(petEntity));
    }


    @Override
    public void delete(Long id) {
        this.petRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.petRepository.existsById(id);
    }
}
