package com.example.backend.dto;

public class BusinessServiceDto {
    private String id;
    private String name;

    public BusinessServiceDto() {}

    public BusinessServiceDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

