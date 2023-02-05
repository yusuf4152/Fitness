package com.coding.fitness.dto.requests;


import java.util.Objects;

public class CreateBodyMetricDto {
    private String userId;

    private double height = 0;

    private double weight = 0;

    private double hip = 0;

    private double chest = 0;

    private double rightSleeve = 0;

    private double leftSleeve = 0;

    private double shoulder = 0;

    private double rightLeg = 0;

    private double leftLeg = 0;

    private double fatRatio = 0;

    private double muscleRatio = 0;

    public CreateBodyMetricDto() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateBodyMetricDto that = (CreateBodyMetricDto) o;
        return Double.compare(that.height, height) == 0 && Double.compare(that.weight, weight) == 0 && Double.compare(that.hip, hip) == 0 && Double.compare(that.chest, chest) == 0 && Double.compare(that.rightSleeve, rightSleeve) == 0 && Double.compare(that.leftSleeve, leftSleeve) == 0 && Double.compare(that.shoulder, shoulder) == 0 && Double.compare(that.rightLeg, rightLeg) == 0 && Double.compare(that.leftLeg, leftLeg) == 0 && Double.compare(that.fatRatio, fatRatio) == 0 && Double.compare(that.muscleRatio, muscleRatio) == 0 && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, height, weight, hip, chest, rightSleeve, leftSleeve, shoulder, rightLeg, leftLeg, fatRatio, muscleRatio);
    }
}
