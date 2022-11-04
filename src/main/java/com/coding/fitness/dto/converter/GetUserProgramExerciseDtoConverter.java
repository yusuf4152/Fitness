package com.coding.fitness.dto.converter;

import com.coding.fitness.dto.responses.GetUserProgramExerciseDto;
import com.coding.fitness.entity.UserProgramExercise;
import org.springframework.stereotype.Component;

@Component
public class GetUserProgramExerciseDtoConverter {
    public GetUserProgramExerciseDto convert(UserProgramExercise from) {
        GetUserProgramExerciseDto getUserProgramExerciseDto = new GetUserProgramExerciseDto();
        getUserProgramExerciseDto.setName(from.getName());
        getUserProgramExerciseDto.setSets(from.getSets());
        getUserProgramExerciseDto.setDescription(from.getDescription());
        getUserProgramExerciseDto.setType(from.getType());
        getUserProgramExerciseDto.setSteps(from.getSteps());
        return getUserProgramExerciseDto;
    }
}

