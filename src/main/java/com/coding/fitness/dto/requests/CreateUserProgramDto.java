package com.coding.fitness.dto.requests;


import com.coding.fitness.dto.responses.GetUserProgramExerciseDto;

import java.time.LocalDateTime;
import java.util.List;


public class CreateUserProgramDto {

    private String programName;
    private String userId;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private List<GetUserProgramExerciseDto> exercises;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public List<GetUserProgramExerciseDto> getExercises() {
        return exercises;
    }

    public void setExercises(List<GetUserProgramExerciseDto> exercises) {
        this.exercises = exercises;
    }
}
