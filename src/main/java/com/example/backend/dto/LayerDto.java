package com.example.backend.dto;

import java.util.List;

public class LayerDto {
    private int index;
    private int timeout;
    private List<String> userIds; // or scheduleIds depending on your model

    public LayerDto() {}

    public LayerDto(int index, int timeout, List<String> userIds) {
        this.index = index;
        this.timeout = timeout;
        this.userIds = userIds;
    }

    public int getIndex() { return index; }
    public void setIndex(int index) { this.index = index; }

    public int getTimeout() { return timeout; }
    public void setTimeout(int timeout) { this.timeout = timeout; }

    public List<String> getUserIds() { return userIds; }
    public void setUserIds(List<String> userIds) { this.userIds = userIds; }
}
