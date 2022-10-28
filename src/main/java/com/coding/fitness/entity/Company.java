package com.coding.fitness.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Company {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String address;
    private LocalDateTime createdAt= LocalDateTime.now();
    private String phoneNumber;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "company")
    private List<MemberShip> memberShips;

    public Company(String id, String name, String address, LocalDateTime createdAt, String phoneNumber, List<MemberShip> memberShips) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createdAt = createdAt;
        this.phoneNumber = phoneNumber;
        this.memberShips = memberShips;
    }
    public Company(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<MemberShip> getMemberShips() {
        return memberShips;
    }

    public void setMemberShips(List<MemberShip> memberShips) {
        this.memberShips = memberShips;
    }
}
