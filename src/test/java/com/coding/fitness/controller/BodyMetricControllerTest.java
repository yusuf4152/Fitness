package com.coding.fitness.controller;

import com.coding.fitness.dto.requests.CreateBodyMetricDto;
import com.coding.fitness.dto.responses.GetBodyMetricDto;
import com.coding.fitness.dto.responses.GetUserDto;
import com.coding.fitness.service.BodyMetricService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BodyMetricController.class)
@AutoConfigureMockMvc
class BodyMetricControllerTest {

    @MockBean
    private BodyMetricService bodyMetricService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createBodyMetric() throws Exception {
        CreateBodyMetricDto createBodyMetricDto = new CreateBodyMetricDto();
        createBodyMetricDto.setUserId("123456789");
        createBodyMetricDto.setHeight(178);
        createBodyMetricDto.setChest(32);

        GetUserDto getUserDto= new GetUserDto();
        getUserDto.setId("123456789");
        getUserDto.setName("yusuf");

        GetBodyMetricDto getBodyMetricDto = new GetBodyMetricDto();
        getBodyMetricDto.setHeight(178);
        getBodyMetricDto.setChest(32);
        getBodyMetricDto.setUser(getUserDto);

        when(bodyMetricService.createBodyMetric(any())).thenReturn(getBodyMetricDto);

         MvcResult mvcResult= mockMvc.perform(post("/api/v1/bodyMetric/createBodyMetric")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(createBodyMetricDto)))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andReturn();
         String result= mvcResult.getResponse().getContentAsString();
         then(result).isEqualTo(objectMapper.writeValueAsString(getBodyMetricDto));
    }
}