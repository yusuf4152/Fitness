package com.coding.fitness.repository;

import com.coding.fitness.entity.BodyMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyMetricRepository extends JpaRepository<BodyMetric, Long> {
    List<BodyMetric> findAllByUser_Id(String userId);
}
