package com.coding.fitness.dto.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateCompanyDto {
    @NotNull(message = "name must be not null")
    @NotBlank(message = "name must be not blank")
    private String name;
    @NotNull(message = "address must be not null")
    @NotBlank(message = "address must be not blank")
    private String address;
    @NotNull(message = "phone number must be not null")
    @NotBlank(message = "phone number must be not blank")
    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
