package com.coding.fitness.repository;

import com.coding.fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<User, String>, PagingAndSortingRepository<User, String> {
}
