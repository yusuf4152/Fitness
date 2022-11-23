package com.coding.fitness.dto.converter;

import com.coding.fitness.dto.responses.GetHubExerciseDto;
import com.coding.fitness.entity.HubExercise;
import org.springframework.stereotype.Component;

@Component
public class GetHubExerciseDtoConverter {
    public GetHubExerciseDto convert(HubExercise from) {
        GetHubExerciseDto getHubExerciseDto = new GetHubExerciseDto();
        getHubExerciseDto.setId(from.getId());
        getHubExerciseDto.setName(from.getName());
        getHubExerciseDto.setDescription(from.getDescription());
        getHubExerciseDto.setSets(from.getSets());
        getHubExerciseDto.setType(from.getType());
        getHubExerciseDto.setSteps(from.getSteps());
        getHubExerciseDto.setImagePath(from.getImagePath());
        getHubExerciseDto.setImageFileName(from.getImageFileName());
        return getHubExerciseDto;
    }
}
