package com.coding.fitness.controller;


import com.coding.fitness.dto.CreateBodyMetricDto;
import com.coding.fitness.dto.GetBodyMetricDto;
import com.coding.fitness.service.BodyMetricService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bodyMetric")
public class BodyMetricController {

    private final BodyMetricService bodyMetricService;

    public BodyMetricController(BodyMetricService bodyMetricService) {
        this.bodyMetricService = bodyMetricService;
    }

    @PostMapping("/createBodyMetric")
    public ResponseEntity<GetBodyMetricDto> createBodyMetric(CreateBodyMetricDto createBodyMetricDto) {
        return ResponseEntity.ok(bodyMetricService.createBodyMetric(createBodyMetricDto));
    }

    @GetMapping("/getAllBodyMetricsByUserId")
    public ResponseEntity<List<GetBodyMetricDto>> getAllBodyMetricsByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(bodyMetricService.getAllBodyMetricsByUserId(userId));
    }
}
