package com.coding.fitness.dto.converter;

import com.coding.fitness.dto.GetBodyMetricDto;
import com.coding.fitness.entity.BodyMetric;
import org.springframework.stereotype.Component;

@Component
public class GetBodyMetricDtoConverter {
    private final GetUserDtoConverter getUserDtoConverter;

    public GetBodyMetricDtoConverter(GetUserDtoConverter getUserDtoConverter) {
        this.getUserDtoConverter = getUserDtoConverter;
    }

    public GetBodyMetricDto convert(BodyMetric from) {
        GetBodyMetricDto getBodyMetricDto = new GetBodyMetricDto();
        getBodyMetricDto.setChest(from.getChest());
        getBodyMetricDto.setHeight(from.getHeight());
        getBodyMetricDto.setHip(from.getHip());
        getBodyMetricDto.setFatRatio(from.getFatRatio());
        getBodyMetricDto.setLeftLeg(from.getLeftLeg());
        getBodyMetricDto.setLeftSleeve(from.getLeftSleeve());
        getBodyMetricDto.setMuscleRatio(from.getMuscleRatio());
        getBodyMetricDto.setShoulder(from.getShoulder());
        getBodyMetricDto.setRightLeg(from.getRightLeg());
        getBodyMetricDto.setRightSleeve(from.getRightSleeve());
        getBodyMetricDto.setWeight(from.getWeight());
        getBodyMetricDto.setUser(getUserDtoConverter.convert(from.getUser()));
        return getBodyMetricDto;
    }
}
