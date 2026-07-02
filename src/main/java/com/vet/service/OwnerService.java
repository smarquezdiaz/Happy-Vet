package com.vet.service;

import com.vet.persistence.entity.OwnerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService {

    public  List<OwnerEntity> getAll();

    public  OwnerEntity get(Long petId);

    public  OwnerEntity save(OwnerEntity ownerEntity);
}
