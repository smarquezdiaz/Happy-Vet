package com.vet.service.impl;

import com.vet.persistence.entity.OwnerEntity;
import com.vet.persistence.repository.OwnerRepository;
import com.vet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerEntity> getAll() {
        return this.ownerRepository.findAll();
    }

    @Override
    public OwnerEntity get(Long petId) {
        return this.ownerRepository.findById(petId).orElse(null);
    }

    @Override
    public OwnerEntity save(OwnerEntity ownerEntity) {
        return this.ownerRepository.save(ownerEntity);
    }
}
