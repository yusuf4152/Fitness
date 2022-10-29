package com.coding.fitness.repository;

import com.coding.fitness.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyRepository extends JpaRepository<Company,String>, PagingAndSortingRepository<Company,String> {
}
