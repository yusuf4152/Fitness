package com.coding.fitness.service;

import com.coding.fitness.dto.requests.CreateUserDto;
import com.coding.fitness.dto.requests.UpdateUserDto;
import com.coding.fitness.dto.responses.GetUserDto;
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
    private final UserMemberShipTransactionService userMemberShipTransactionService;

    public UserService(UserRepository userRepository, GetUserDtoConverter getUserDtoConverter,
                       UserMemberShipTransactionService userMemberShipTransactionService) {
        this.userRepository = userRepository;
        this.getUserDtoConverter = getUserDtoConverter;
        this.userMemberShipTransactionService = userMemberShipTransactionService;
    }

    public GetUserDto createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setAge(createUserDto.getAge());
        user.setEmail(createUserDto.getEmail());
        user.setName(createUserDto.getName());
        user.setSurname(createUserDto.getSurname());
        user.setPassword(createUserDto.getPassword());
        if (emailDuplicateCheck(createUserDto.getEmail())) {
            throw new DataIntegrityViolationException(createUserDto.getEmail() + " kullanılmıştır");
        }
        User savedUser = userRepository.save(user);
        return getUserDtoConverter.convert(savedUser);
    }

    public GetUserDto updateUser(UpdateUserDto updateUserDto) {
        User user = getUserById(updateUserDto.getUserId());
        user.setAge((updateUserDto.getAge() == 0) ? user.getAge() : updateUserDto.getAge());
        user.setName((updateUserDto.getName() == null) ? user.getName() : updateUserDto.getName());
        user.setSurname((updateUserDto.getSurname() == null) ? user.getSurname() : updateUserDto.getSurname());
        return getUserDtoConverter.convert(userRepository.save(user));
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
        userMemberShipTransactionService.deleteMemberShipByUserId(id);
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
