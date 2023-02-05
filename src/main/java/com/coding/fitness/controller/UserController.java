package com.coding.fitness.controller;

import com.coding.fitness.dto.requests.CreateUserDto;
import com.coding.fitness.dto.requests.UpdateUserDto;
import com.coding.fitness.dto.responses.GetUserDto;
import com.coding.fitness.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<GetUserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserDto));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<GetUserDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping("/getAllUsersByName")
    public ResponseEntity<List<GetUserDto>> getAllUsersByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.getAllUserByName(name));
    }

    @DeleteMapping("/deleteUserById")
    public ResponseEntity<GetUserDto> deleteUserById(@RequestParam String id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<GetUserDto> updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
        return ResponseEntity.ok(userService.updateUser(updateUserDto));
    }
}
