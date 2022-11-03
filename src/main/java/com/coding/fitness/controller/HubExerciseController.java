package com.coding.fitness.controller;

import com.coding.fitness.dto.requests.CreateHubExerciseDto;
import com.coding.fitness.dto.responses.GetHubExerciseDto;
import com.coding.fitness.service.HubExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hubExercise")
public class HubExerciseController {

    private final HubExerciseService hubExerciseService;

    public HubExerciseController(HubExerciseService hubExerciseService) {
        this.hubExerciseService = hubExerciseService;
    }

    @PostMapping("/createHubExercise")
    public ResponseEntity<GetHubExerciseDto> createHubExercise(@RequestBody CreateHubExerciseDto createHubExerciseDto) {

        return ResponseEntity.ok(hubExerciseService.createHubExercise(createHubExerciseDto));
    }

    @GetMapping("/getAllHubExercises")
    public ResponseEntity<List<GetHubExerciseDto>> getAllHubExercises() {

        return ResponseEntity.ok(hubExerciseService.getAllHubExercises());
    }
}
