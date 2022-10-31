package com.coding.fitness.entity;


import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
public class BodyMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private double height;

    private double weight;

    private double hip;

    private double chest;

    private double rightSleeve;

    private double leftSleeve;

    private double shoulder;

    private double rightLeg;

    private double leftLeg;

    private double fatRatio;

    private double muscleRatio;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public BodyMetric(long id, double height, double weight, double hip, double chest, double rightSleeve,
                      double leftSleeve, double shoulder, double rightLeg, double leftLeg, double fatRatio,
                      double muscleRatio, LocalDateTime createdAt, User user) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.hip = hip;
        this.chest = chest;
        this.rightSleeve = rightSleeve;
        this.leftSleeve = leftSleeve;
        this.shoulder = shoulder;
        this.rightLeg = rightLeg;
        this.leftLeg = leftLeg;
        this.fatRatio = fatRatio;
        this.muscleRatio = muscleRatio;
        this.createdAt = createdAt;
        this.user = user;
    }
    public BodyMetric(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getRightSleeve() {
        return rightSleeve;
    }

    public void setRightSleeve(double rightSleeve) {
        this.rightSleeve = rightSleeve;
    }

    public double getLeftSleeve() {
        return leftSleeve;
    }

    public void setLeftSleeve(double leftSleeve) {
        this.leftSleeve = leftSleeve;
    }

    public double getShoulder() {
        return shoulder;
    }

    public void setShoulder(double shoulder) {
        this.shoulder = shoulder;
    }

    public double getRightLeg() {
        return rightLeg;
    }

    public void setRightLeg(double rightLeg) {
        this.rightLeg = rightLeg;
    }

    public double getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(double leftLeg) {
        this.leftLeg = leftLeg;
    }

    public double getFatRatio() {
        return fatRatio;
    }

    public void setFatRatio(double fatRatio) {
        this.fatRatio = fatRatio;
    }

    public double getMuscleRatio() {
        return muscleRatio;
    }

    public void setMuscleRatio(double muscleRatio) {
        this.muscleRatio = muscleRatio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}





