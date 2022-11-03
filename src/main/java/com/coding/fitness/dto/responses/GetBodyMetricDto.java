package com.coding.fitness.dto.responses;

public class GetBodyMetricDto {
    private GetUserDto user;

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

    public GetUserDto getUser() {
        return user;
    }

    public void setUser(GetUserDto user) {
        this.user = user;
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
}
