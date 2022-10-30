package com.coding.fitness.service;

import com.coding.fitness.dto.CreateUserDto;
import com.coding.fitness.dto.GetUserDto;
import com.coding.fitness.dto.converter.GetUserDtoConverter;
import com.coding.fitness.entity.User;
import com.coding.fitness.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
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
        if (!emailDuplicateCheck(createUserDto.getEmail())) {
            throw new DataIntegrityViolationException(createUserDto.getEmail() + " kullanılmıştır");
        }
        User savedUser = userRepository.save(user);
        return getUserDtoConverter.convert(savedUser);
    }

    protected User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + "user not found"));
    }

    public boolean emailDuplicateCheck(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user == null) {
            return true;
        }
        return false;
    }

    public GetUserDto deleteUserById(String id) {
        User user = getUserById(id);
        user.setDeleted(true);
        userRepository.save(user);
        return getUserDtoConverter.convert(user);
    }

    public List<GetUserDto> getAllUser() {
        return userRepository
                .findAllByIsDeletedFalse()
                .stream()
                .map(getUserDtoConverter::convert).collect(Collectors.toList());
    }

    public List<GetUserDto> getAllUserByName(String name) {
        return userRepository.findAllByName(name)
                .stream()
                .map(getUserDtoConverter::convert).collect(Collectors.toList());
    }
}
