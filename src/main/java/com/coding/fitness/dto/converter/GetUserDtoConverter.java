package com.coding.fitness.dto.converter;

import com.coding.fitness.dto.responses.GetUserDto;
import com.coding.fitness.entity.User;
import org.springframework.stereotype.Component;

@Component
public class GetUserDtoConverter {
    public GetUserDto convert(User from) {
        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setId(from.getId());
        getUserDto.setAge(from.getAge());
        getUserDto.setActive(from.isActive());
        getUserDto.setDeleted(from.isDeleted());
        getUserDto.setEmail(from.getEmail());
        getUserDto.setName(from.getName());
        getUserDto.setRole(from.getRole());
        getUserDto.setCreatedAt(from.getCreatedAt());
        getUserDto.setSurname(from.getSurname());
        return getUserDto;
    }
}
