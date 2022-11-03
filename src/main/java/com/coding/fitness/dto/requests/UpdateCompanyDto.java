package com.coding.fitness.dto.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateCompanyDto {

    @NotBlank(message = "id must be not blank")
    @NotNull(message = "id must be not null")
    private String id;
    @NotBlank(message = "name must be not blank")
    private String name;
    @NotBlank(message = "address must be not blank")
    private String address;
    @NotBlank(message = "phone number must be not blank")
    private String phoneNumber;

    public UpdateCompanyDto() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
