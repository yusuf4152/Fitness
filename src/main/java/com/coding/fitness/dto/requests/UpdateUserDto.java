package com.coding.fitness.dto.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDto {

    private String userId;
    @Size(min = 3,max = 50,message ="namespace must be between 3 and 5 characters")
    private String name;
    @Size(min = 3,max = 50,message ="namespace must be between 3 and 5 characters")
    private String surname;
    @Min(value = 0,message = "age is min 0")
    private int age;

    public UpdateUserDto(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
