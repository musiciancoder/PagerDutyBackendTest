package com.example.backend.utility;

import com.example.backend.dto.ServiceDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceResponseWrapper {
    private List<ServiceDto> services;

    public List<ServiceDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceDto> services) {
        this.services = services;
    }
}
