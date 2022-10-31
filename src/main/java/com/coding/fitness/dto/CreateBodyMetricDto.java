package com.coding.fitness.dto;


public class CreateBodyMetricDto {
    private String userId;

    private double height=0;

    private double weight=0;

    private double hip=0;

    private double chest=0;

    private double rightSleeve=0;

    private double leftSleeve=0;

    private double shoulder=0;

    private double rightLeg=0;

    private double leftLeg=0;

    private double fatRatio=0;

    private double muscleRatio=0;

    public CreateBodyMetricDto(String userId, double height, double weight, double hip, double chest,
                               double rightSleeve, double leftSleeve, double shoulder, double rightLeg,
                               double leftLeg, double fatRatio, double muscleRatio) {
        this.userId = userId;
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
    }
    public CreateBodyMetricDto(){}

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
}
