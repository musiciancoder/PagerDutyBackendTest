package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class ServiceDependency {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Service supportingService;

    @ManyToOne
    private Service dependentService;

    public ServiceDependency() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Service getSupportingService() { return supportingService; }
    public void setSupportingService(Service supportingService) { this.supportingService = supportingService; }

    public Service getDependentService() { return dependentService; }
    public void setDependentService(Service dependentService) { this.dependentService = dependentService; }
}
