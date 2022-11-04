package com.coding.fitness.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class UserProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String programName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userProgram")
    private List<UserProgramExercise> userProgramExercises;
    public UserProgram(){}

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserProgramExercise> getUserProgramExercises() {
        return userProgramExercises;
    }

    public void setUserProgramExercises(List<UserProgramExercise> userProgramExercises) {
        this.userProgramExercises = userProgramExercises;
    }
}
