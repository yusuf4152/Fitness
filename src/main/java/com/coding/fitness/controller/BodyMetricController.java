package com.coding.fitness.controller;


import com.coding.fitness.dto.requests.CreateBodyMetricDto;
import com.coding.fitness.dto.responses.GetBodyMetricDto;
import com.coding.fitness.service.BodyMetricService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<GetBodyMetricDto> createBodyMetric(@RequestBody CreateBodyMetricDto createBodyMetricDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodyMetricService.createBodyMetric(createBodyMetricDto));
    }

    @GetMapping("/getAllBodyMetricsByUserId")
    public ResponseEntity<List<GetBodyMetricDto>> getAllBodyMetricsByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(bodyMetricService.getAllBodyMetricsByUserId(userId));
    }

    @DeleteMapping("/deleteBodyMetricById/{id}")
    public ResponseEntity<String> deleteBodyMetricById(@PathVariable long id) {
        return ResponseEntity.ok(bodyMetricService.deleteBodyMetricById(id));
    }
}
