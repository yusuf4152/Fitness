package com.coding.fitness.controller;

import com.coding.fitness.dto.requests.CreateUserDto;
import com.coding.fitness.dto.requests.UpdateUserDto;
import com.coding.fitness.dto.responses.GetUserDto;
import com.coding.fitness.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUser() throws Exception {
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setName("yusuf");
        createUserDto.setSurname("demir");
        createUserDto.setAge(21);
        createUserDto.setEmail("yusuf@mail.com");
        createUserDto.setPassword("123456789");

        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setName("yusuf");
        getUserDto.setSurname("demir");
        getUserDto.setAge(21);
        getUserDto.setEmail("yusuf@mail.com");
        when(userService.createUser(createUserDto)).thenReturn(getUserDto);
        MvcResult mvcResult = mockMvc.perform(post("/api/v1/user/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUserDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        verify(userService).createUser(createUserDto);
        String result = mvcResult.getResponse().getContentAsString();
        then(result).isEqualTo(objectMapper.writeValueAsString(getUserDto));
    }

    @Test
    void getAllUsers() throws Exception {
        List<GetUserDto> getUserDtos = new ArrayList<>();
        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setName("yusuf");
        getUserDto.setSurname("demir");
        getUserDto.setAge(21);
        getUserDto.setEmail("yusuf@mail.com");
        GetUserDto getUserDto1 = new GetUserDto();
        getUserDto1.setName("ali");
        getUserDto1.setSurname("veli");
        getUserDto1.setEmail("aliveli@mail.com");
        getUserDto1.setAge(20);
        getUserDtos.add(getUserDto);
        getUserDtos.add(getUserDto1);
        when(userService.getAllUser()).thenReturn(getUserDtos);
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/user/getAllUsers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        verify(userService).getAllUser();
        String result = mvcResult.getResponse().getContentAsString();
        then(result).isEqualTo(objectMapper.writeValueAsString(getUserDtos));
    }

    @Test
    void getAllUsersByName() throws Exception {
        List<GetUserDto> getUserDtos = new ArrayList<>();
        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setName("yusuf");
        getUserDto.setSurname("demir");
        getUserDto.setAge(21);
        getUserDto.setEmail("yusuf@mail.com");
        GetUserDto getUserDto1 = new GetUserDto();
        getUserDto1.setName("yusuf");
        getUserDto1.setSurname("veli");
        getUserDto1.setEmail("aliveli@mail.com");
        getUserDto1.setAge(20);
        getUserDtos.add(getUserDto);
        getUserDtos.add(getUserDto1);
        when(userService.getAllUserByName("yusuf")).thenReturn(getUserDtos);
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/user/getAllUsersByName?name=yusuf")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        then(result).isEqualTo(objectMapper.writeValueAsString(getUserDtos));
    }

    @Test
    void deleteUserById() throws Exception {

        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setName("yusuf");
        getUserDto.setSurname("demir");
        getUserDto.setAge(21);
        getUserDto.setEmail("yusuf@mail.com");
        getUserDto.setId("23423423423");
        when(userService.deleteUserById("23423423423")).thenReturn(getUserDto);
        MvcResult mvcResult = mockMvc.perform(delete("/api/v1/user/deleteUserById?id=23423423423")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        verify(userService).deleteUserById("23423423423");
        String result = mvcResult.getResponse().getContentAsString();
        then(result).isEqualTo(objectMapper.writeValueAsString(getUserDto));


    }

    @Test
    void updateUser() throws Exception {
        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.setName("yusuf");
        updateUserDto.setUserId("123456789");

        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setId("123456789");
        getUserDto.setName("yusuf");
        getUserDto.setAge(21);

        when(userService.updateUser(updateUserDto)).thenReturn(getUserDto);
        MvcResult mvcResult = mockMvc.perform(put("/api/v1/user/updateUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateUserDto)))
                .andDo(print())
                .andReturn();
        verify(userService).updateUser(updateUserDto);
        String result = mvcResult.getResponse().getContentAsString();
        then(result).isEqualTo(objectMapper.writeValueAsString(getUserDto));
    }


}