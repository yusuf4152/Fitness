package com.coding.fitness.service;


import com.coding.fitness.dto.converter.GetUserProgramDtoConverter;
import com.coding.fitness.dto.requests.CreateUserProgramDto;
import com.coding.fitness.dto.responses.GetUserProgramDto;
import com.coding.fitness.dto.responses.GetUserProgramExerciseDto;
import com.coding.fitness.entity.UserProgram;
import com.coding.fitness.entity.UserProgramExercise;
import com.coding.fitness.repository.UserProgramRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProgramService {
    private final UserProgramRepository userProgramRepository;
    private final UserService userService;
    private final GetUserProgramDtoConverter getUserProgramDtoConverter;

    public UserProgramService(UserProgramRepository userProgramRepository, UserService userService,
                              GetUserProgramDtoConverter getUserProgramDtoConverter) {
        this.userProgramRepository = userProgramRepository;
        this.userService = userService;
        this.getUserProgramDtoConverter = getUserProgramDtoConverter;
    }

    public GetUserProgramDto createUserProgram(CreateUserProgramDto createUserProgramDto) {
        UserProgram userProgram = new UserProgram();
        userProgram.setProgramName(createUserProgramDto.getProgramName());
        userProgram.setStartDate(createUserProgramDto.getStartDate());
        userProgram.setFinishDate(createUserProgramDto.getFinishDate());
        userProgram.setUser(userService.getUserById(createUserProgramDto.getUserId()));
        List<UserProgramExercise> userProgramExercises = new ArrayList<>();
        List<GetUserProgramExerciseDto> dtoExerciseList = createUserProgramDto.getExercises();
        for (GetUserProgramExerciseDto exerciseDto : dtoExerciseList) {
            UserProgramExercise userProgramExercise = new UserProgramExercise();
            userProgramExercise.setName(exerciseDto.getName());
            userProgramExercise.setDescription(exerciseDto.getDescription());
            userProgramExercise.setSets(exerciseDto.getSets());
            userProgramExercise.setType(exerciseDto.getType());
            userProgramExercise.setSteps(exerciseDto.getSteps());
            userProgramExercise.setUserProgram(userProgram);
            userProgramExercises.add(userProgramExercise);
        }
        userProgram.setUserProgramExercises(userProgramExercises);
        return getUserProgramDtoConverter.convert(userProgramRepository.save(userProgram));
    }

    public List<GetUserProgramDto> getAllUserProgram(String userId) {
        List<UserProgram> programs = userProgramRepository.findAllByUser_Id(userId);
        return programs.stream().map(getUserProgramDtoConverter::convert).collect(Collectors.toList());
    }
}
