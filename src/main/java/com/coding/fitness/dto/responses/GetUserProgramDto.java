package com.coding.fitness.dto.responses;

import java.time.LocalDateTime;
import java.util.List;

public class GetUserProgramDto {

    private long id;
    private String programName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private List<GetUserProgramExerciseDto> exercises;
    public GetUserProgramDto(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
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
