package com.coding.fitness.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserProgramExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @ElementCollection
    private List<String> sets;
    private String type;
    @ElementCollection
    private List<String> steps;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserProgram userProgram;

    public UserProgramExercise() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSets() {
        return sets;
    }

    public void setSets(List<String> sets) {
        this.sets = sets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public UserProgram getUserProgram() {
        return userProgram;
    }

    public void setUserProgram(UserProgram userProgram) {
        this.userProgram = userProgram;
    }
}
