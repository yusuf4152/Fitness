package com.coding.fitness.service;

import com.coding.fitness.dto.CreateUserDto;
import com.coding.fitness.dto.GetCompanyDto;
import com.coding.fitness.dto.GetUserDto;
import com.coding.fitness.dto.converter.GetUserDtoConverter;
import com.coding.fitness.entity.User;
import com.coding.fitness.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final GetUserDtoConverter getUserDtoConverter;

    public UserService(UserRepository userRepository, GetUserDtoConverter getUserDtoConverter) {
        this.userRepository = userRepository;
        this.getUserDtoConverter = getUserDtoConverter;
    }

    public GetUserDto createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setAge(createUserDto.getAge());
        user.setEmail(createUserDto.getEmail());
        user.setName(createUserDto.getName());
        user.setSurname(createUserDto.getSurname());
        user.setPassword(createUserDto.getPassword());
        User savedUser = userRepository.save(user);
        return getUserDtoConverter.convert(user);
    }

    public List<GetUserDto> getAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable).get()
                .map(getUserDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
