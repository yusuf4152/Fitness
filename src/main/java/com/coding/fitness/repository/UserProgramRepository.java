package com.coding.fitness.repository;

import com.coding.fitness.entity.UserProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProgramRepository extends JpaRepository<UserProgram, Long> {

    List<UserProgram> findAllByUser_Id(String userId);
}
