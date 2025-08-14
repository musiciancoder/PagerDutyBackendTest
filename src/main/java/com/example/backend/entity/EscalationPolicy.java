package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EscalationPolicy {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "escalationPolicy")
    private List<EscalationLayer> layers = new ArrayList<>();

    public EscalationPolicy() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<EscalationLayer> getLayers() { return layers; }
    public void setLayers(List<EscalationLayer> layers) { this.layers = layers; }
}
