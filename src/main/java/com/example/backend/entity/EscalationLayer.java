package com.example.backend.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EscalationLayer {
    @Id
    @GeneratedValue
    private Long id;
    private int delay;

    @ManyToOne
    private EscalationPolicy escalationPolicy;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    public EscalationLayer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getDelay() { return delay; }
    public void setDelay(int delay) { this.delay = delay; }

    public EscalationPolicy getEscalationPolicy() { return escalationPolicy; }
    public void setEscalationPolicy(EscalationPolicy escalationPolicy) { this.escalationPolicy = escalationPolicy; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
}
