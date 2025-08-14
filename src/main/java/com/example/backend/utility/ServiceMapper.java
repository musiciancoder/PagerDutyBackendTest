package com.example.backend.utility;

import com.example.backend.dto.ServiceDto;
import com.example.backend.entity.Service;

public class ServiceMapper {

    public Service mapToEntity(ServiceDto dto) {
        Service entity = new Service();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        // entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public ServiceDto mapToDto(Service entity) {
        ServiceDto dto = new ServiceDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}
