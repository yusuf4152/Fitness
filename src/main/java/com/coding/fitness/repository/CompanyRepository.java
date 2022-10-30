package com.coding.fitness.repository;

import com.coding.fitness.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company,String>{
    List<Company> findAllByName(String name);
}
