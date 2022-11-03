package com.coding.fitness.service;

import com.coding.fitness.dto.converter.GetHubExerciseDtoConverter;
import com.coding.fitness.dto.requests.CreateHubExerciseDto;
import com.coding.fitness.dto.responses.GetHubExerciseDto;
import com.coding.fitness.entity.HubExercise;
import com.coding.fitness.repository.HubExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HubExerciseService {
    private final HubExerciseRepository hubExerciseRepository;
    private final GetHubExerciseDtoConverter getHubExerciseDtoConverter;

    public HubExerciseService(HubExerciseRepository hubExerciseRepository,
                              GetHubExerciseDtoConverter getHubExerciseDtoConverter) {
        this.hubExerciseRepository = hubExerciseRepository;
        this.getHubExerciseDtoConverter = getHubExerciseDtoConverter;
    }

    public GetHubExerciseDto createHubExercise(CreateHubExerciseDto createHubExerciseDto) {
        HubExercise hubExercise = new HubExercise();
        hubExercise.setName(createHubExerciseDto.getName());
        hubExercise.setDescription(createHubExerciseDto.getDescription());
        hubExercise.setSets(createHubExerciseDto.getSets());
        hubExercise.setSteps(createHubExerciseDto.getSteps());
        hubExercise.setType(createHubExerciseDto.getType());
        return getHubExerciseDtoConverter.convert(hubExerciseRepository.save(hubExercise));
    }

    public List<GetHubExerciseDto> getAllHubExercises() {
        return hubExerciseRepository.findAll()
                .stream()
                .map(getHubExerciseDtoConverter::convert).collect(Collectors.toList());
    }

}
