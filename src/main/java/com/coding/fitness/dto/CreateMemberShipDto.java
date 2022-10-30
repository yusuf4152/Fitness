package com.coding.fitness.dto;

import java.time.LocalDateTime;

public class CreateMemberShipDto {
    private String companyId;
    private String userId;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    public CreateMemberShipDto(String companyId, String userId, LocalDateTime startDate, LocalDateTime finishDate) {
        this.companyId = companyId;
        this.userId = userId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public CreateMemberShipDto() {

    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
}
