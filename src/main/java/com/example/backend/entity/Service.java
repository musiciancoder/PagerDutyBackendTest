package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Service {
    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    private EscalationPolicy escalationPolicy;

    @OneToMany(mappedBy = "dependentService")
    private List<ServiceDependency> dependencies = new ArrayList<>();

    public Service() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public EscalationPolicy getEscalationPolicy() { return escalationPolicy; }
    public void setEscalationPolicy(EscalationPolicy escalationPolicy) { this.escalationPolicy = escalationPolicy; }

    public List<ServiceDependency> getDependencies() { return dependencies; }
    public void setDependencies(List<ServiceDependency> dependencies) { this.dependencies = dependencies; }
}
