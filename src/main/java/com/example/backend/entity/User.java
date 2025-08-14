package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`PG_USER`") // Escapes the table name to avoid conflicts with reserved keywords
public class User {
    @Id
    private String id;
    private String name;
    private String email;

    @ManyToMany(mappedBy = "users")
    private List<EscalationLayer> escalationLayers = new ArrayList<>();

    public User() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<EscalationLayer> getEscalationLayers() { return escalationLayers; }
    public void setEscalationLayers(List<EscalationLayer> escalationLayers) { this.escalationLayers = escalationLayers; }
}
