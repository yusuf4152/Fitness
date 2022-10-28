package com.coding.fitness.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MemberShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "memberShip")
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    public MemberShip(String id, Company company, User user, LocalDateTime startDate, LocalDateTime finishDate) {
        this.id = id;
        this.company = company;
        this.user = user;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public MemberShip() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
