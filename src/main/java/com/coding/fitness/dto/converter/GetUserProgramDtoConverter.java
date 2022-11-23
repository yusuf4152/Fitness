package com.coding.fitness.dto.converter;

import com.coding.fitness.dto.responses.GetUserProgramDto;
import com.coding.fitness.entity.UserProgram;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GetUserProgramDtoConverter {
    private final GetUserProgramExerciseDtoConverter getUserProgramExerciseDtoConverter;

    public GetUserProgramDtoConverter(GetUserProgramExerciseDtoConverter getUserProgramExerciseDtoConverter) {
        this.getUserProgramExerciseDtoConverter = getUserProgramExerciseDtoConverter;
    }

    public GetUserProgramDto convert(UserProgram from) {
        GetUserProgramDto getUserProgramDto = new GetUserProgramDto();
        getUserProgramDto.setId(from.getId());
        getUserProgramDto.setProgramName(from.getProgramName());
        getUserProgramDto.setStartDate(from.getStartDate());
        getUserProgramDto.setFinishDate(from.getFinishDate());
        getUserProgramDto.setExercises(
                from.getUserProgramExercises().stream()
                        .map(getUserProgramExerciseDtoConverter::convert)
                        .collect(Collectors.toList())
        );
        return getUserProgramDto;
    }
}
