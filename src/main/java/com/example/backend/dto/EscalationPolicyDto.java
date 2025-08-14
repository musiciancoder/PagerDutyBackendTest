package com.example.backend.dto;

import java.util.List;

public class EscalationPolicyDto {
    private String id;
    private String name;
    private List<LayerDto> layers;

    public EscalationPolicyDto() {};

    public EscalationPolicyDto(String id, String name, List<LayerDto> layers) {
        this.id = id;
        this.name = name;
        this.layers = layers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LayerDto> getLayers() {
        return layers;
    }

    public void setLayers(List<LayerDto> layers) {
        this.layers = layers;
    }
}
