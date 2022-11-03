package com.coding.fitness.repository;

import com.coding.fitness.entity.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberShipRepository extends JpaRepository<MemberShip, Long> {
    List<MemberShip> findAllByCompany_IdAndIsActiveTrue(String id);

    MemberShip findByUser_IdAndIsActiveTrue(String id);
}
