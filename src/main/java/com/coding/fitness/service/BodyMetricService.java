package com.coding.fitness.service;

import com.coding.fitness.dto.requests.CreateBodyMetricDto;
import com.coding.fitness.dto.responses.GetBodyMetricDto;
import com.coding.fitness.dto.converter.GetBodyMetricDtoConverter;
import com.coding.fitness.entity.BodyMetric;
import com.coding.fitness.repository.BodyMetricRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodyMetricService {

    private final UserService userService;
    private final BodyMetricRepository bodyMetricRepository;

    private final GetBodyMetricDtoConverter getBodyMetricDtoConverter;

    public BodyMetricService(UserService userService, BodyMetricRepository bodyMetricRepository,
                             GetBodyMetricDtoConverter getBodyMetricDtoConverter) {
        this.userService = userService;
        this.bodyMetricRepository = bodyMetricRepository;
        this.getBodyMetricDtoConverter = getBodyMetricDtoConverter;
    }

    public GetBodyMetricDto createBodyMetric(CreateBodyMetricDto createBodyMetricDto) {
        BodyMetric bodyMetric = BodyMetric.builder()
                .hip(createBodyMetricDto.getHip())
                .chest(createBodyMetricDto.getChest())
                .leftLeg(createBodyMetricDto.getLeftLeg())
                .height(createBodyMetricDto.getHeight())
                .fatRatio(createBodyMetricDto.getFatRatio())
                .rightLeg(createBodyMetricDto.getRightLeg())
                .leftSleeve(createBodyMetricDto.getLeftSleeve())
                .shoulder(createBodyMetricDto.getShoulder())
                .muscleRatio(createBodyMetricDto.getMuscleRatio())
                .weight(createBodyMetricDto.getWeight())
                .rightSleeve(createBodyMetricDto.getRightSleeve())
                .user(userService.getUserById(createBodyMetricDto.getUserId()))
                .build();
        bodyMetricRepository.save(bodyMetric);
        return getBodyMetricDtoConverter.convert(bodyMetric);
    }

    public List<GetBodyMetricDto> getAllBodyMetricsByUserId(String userId) {
        return bodyMetricRepository.findAllByUser_Id(userId)
                .stream()
                .map(getBodyMetricDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
