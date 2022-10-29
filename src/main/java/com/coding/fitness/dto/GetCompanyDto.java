package com.coding.fitness.dto;

import java.time.LocalDateTime;

public class GetCompanyDto {
    private String id;
    private String name;
    private String address;
    private LocalDateTime createdAt;
    private String phoneNumber;

    public GetCompanyDto(String id, String name, String address, LocalDateTime createdAt, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createdAt = createdAt;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
