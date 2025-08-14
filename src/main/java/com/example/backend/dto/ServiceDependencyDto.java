package com.example.backend.dto;

public class ServiceDependencyDto {
    private String supportingServiceId;
    private String dependentServiceId;

    public ServiceDependencyDto() {}

    public ServiceDependencyDto(String supportingServiceId, String dependentServiceId) {
        this.supportingServiceId = supportingServiceId;
        this.dependentServiceId = dependentServiceId;
    }

    public String getSupportingServiceId() {
        return supportingServiceId;
    }

    public void setSupportingServiceId(String supportingServiceId) {
        this.supportingServiceId = supportingServiceId;
    }

    public String getDependentServiceId() {
        return dependentServiceId;
    }

    public void setDependentServiceId(String dependentServiceId) {
        this.dependentServiceId = dependentServiceId;
    }
}
