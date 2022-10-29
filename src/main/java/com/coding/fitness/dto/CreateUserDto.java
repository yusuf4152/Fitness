package com.coding.fitness.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserDto {

    @Size(min = 3,max = 50,message ="namespace must be between 3 and 5 characters")
    @NotNull(message = "name must be not null")
    private String name;
    @Size(min = 3,max = 50,message ="namespace must be between 3 and 5 characters")
    private String surname;
    @Min(value = 0,message = "age is min 0")
    private int age;
    @Email(message = "email must be email format")
    private String email;
    @Size(min = 6, max = 20,message = "password must be between 6 and 20 characters")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
