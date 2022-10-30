package com.coding.fitness.repository;

import com.coding.fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByName(String name);
    List<User> findAllByIsDeletedFalse();
    Optional<User> findUserByEmail(String email);
}
