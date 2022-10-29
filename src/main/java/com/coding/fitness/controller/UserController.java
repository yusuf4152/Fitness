package com.coding.fitness.controller;

import com.coding.fitness.dto.CreateUserDto;
import com.coding.fitness.dto.GetUserDto;
import com.coding.fitness.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public GetUserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }
    @GetMapping("/getAllUsers")
    public List<GetUserDto> getALlUsers(@RequestParam(name = "page", defaultValue = "1") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size){
     return userService.getAllUser(page,size);
    }
}
