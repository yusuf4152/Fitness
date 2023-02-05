package com.coding.fitness.dto.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserDto that = (UpdateUserDto) o;
        return age == that.age && Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, age);
    }
}
