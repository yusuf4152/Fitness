package com.coding.fitness.controller;


import com.coding.fitness.dto.requests.CreateUserProgramDto;
import com.coding.fitness.dto.responses.GetUserProgramDto;
import com.coding.fitness.service.UserProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userProgram")
public class UserProgramController {

    private final UserProgramService userProgramService;

    public UserProgramController(UserProgramService userProgramService) {
        this.userProgramService = userProgramService;
    }

    @PostMapping("/createUserProgram")
    public ResponseEntity<GetUserProgramDto> createUserProgram(@RequestBody CreateUserProgramDto createUserProgramDto) {

        return ResponseEntity.ok(userProgramService.createUserProgram(createUserProgramDto));
    }
    @GetMapping("/getAllUserProgram")
    public ResponseEntity<List<GetUserProgramDto>> getAllUserProgram(@RequestParam String userId) {
        return ResponseEntity.ok(userProgramService.getAllUserProgram(userId));
    }
}
