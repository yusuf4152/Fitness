package com.coding.fitness.dto.converter;

import com.coding.fitness.dto.GetMemberShipDto;
import com.coding.fitness.entity.MemberShip;
import org.springframework.stereotype.Component;

@Component
public class GetMemberShipDtoConverter {

    private final GetCompanyDtoConverter getCompanyDtoConverter;
    private final GetUserDtoConverter getUserDtoConverter;
    public GetMemberShipDtoConverter(GetCompanyDtoConverter getCompanyDtoConverter, GetUserDtoConverter getUserDtoConverter) {
        this.getCompanyDtoConverter = getCompanyDtoConverter;
        this.getUserDtoConverter = getUserDtoConverter;
    }

    public GetMemberShipDto convert(MemberShip from){
       GetMemberShipDto getMemberShipDto= new GetMemberShipDto();
       getMemberShipDto.setId(from.getId());
       getMemberShipDto.setFinishDate(from.getFinishDate());
       getMemberShipDto.setStartDate(from.getStartDate());
       getMemberShipDto.setCompany(getCompanyDtoConverter.convert(from.getCompany()));
       getMemberShipDto.setUser(getUserDtoConverter.convert(from.getUser()));
       return getMemberShipDto;
    }
}
