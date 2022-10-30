package com.coding.fitness.dto;

import java.time.LocalDateTime;

public class GetMemberShipDto {
    private Long id;
    private GetCompanyDto company;
    private GetUserDto user;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    public GetMemberShipDto(Long id, GetCompanyDto company, GetUserDto user, LocalDateTime startDate, LocalDateTime finishDate) {
        this.id = id;
        this.company = company;
        this.user = user;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public GetMemberShipDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GetCompanyDto getCompany() {
        return company;
    }

    public void setCompany(GetCompanyDto company) {
        this.company = company;
    }

    public GetUserDto getUser() {
        return user;
    }

    public void setUser(GetUserDto user) {
        this.user = user;
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
