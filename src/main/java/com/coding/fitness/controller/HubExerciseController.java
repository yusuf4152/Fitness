package com.coding.fitness.controller;

import com.coding.fitness.dto.requests.CreateHubExerciseDto;
import com.coding.fitness.dto.responses.GetHubExerciseDto;
import com.coding.fitness.service.HubExerciseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @DeleteMapping("/deleteHubExerciseById")
    public ResponseEntity<String> deleteHubExerciseById(long id) {
        return ResponseEntity.ok(hubExerciseService.deleteHubExerciseById(id) + " " + "deleted");
    }

    @PostMapping(
            path = "/saveImageByExerciseId/{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<GetHubExerciseDto> saveImageByExerciseId(@RequestParam("file") MultipartFile file, @PathVariable long id) {
        return ResponseEntity.ok(hubExerciseService.saveImage(id, file));
    }

    @GetMapping(value = "/downloadImageByExerciseId/{id}")
    public ResponseEntity<byte[]> downloadImageByExerciseId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(hubExerciseService.downloadImageByExerciseId(id));
    }
}
