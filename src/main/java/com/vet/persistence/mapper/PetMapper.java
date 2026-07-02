package com.vet.persistence.mapper;

import com.vet.persistence.entity.PetEntity;
import com.vet.service.dto.CreatePetRequest;
import com.vet.service.dto.PetResponse;
import com.vet.service.dto.UpdatePetRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetResponse toDto(PetEntity entity);

    List<PetResponse> toDto(List<PetEntity> entities);

    PetEntity toEntity(CreatePetRequest dto);

    void updateEntityFromDto(UpdatePetRequest dto, @MappingTarget PetEntity entity);
}
