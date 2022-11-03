package com.coding.fitness.dto.converter;

import com.coding.fitness.dto.responses.GetCompanyDto;
import com.coding.fitness.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class GetCompanyDtoConverter {
    public GetCompanyDto convert(Company from){
        return  new GetCompanyDto(
           from.getId(),
           from.getName(),
           from.getAddress(),
           from.getCreatedAt(),
           from.getPhoneNumber()
        );
    }
}
