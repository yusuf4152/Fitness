package com.coding.fitness.service;

import com.coding.fitness.dto.CreateMemberShipDto;
import com.coding.fitness.dto.GetMemberShipDto;
import com.coding.fitness.dto.converter.GetMemberShipDtoConverter;
import com.coding.fitness.entity.MemberShip;
import com.coding.fitness.entity.User;
import com.coding.fitness.repository.MemberShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberShipService {

    private final MemberShipRepository memberShipRepository;
    private final GetMemberShipDtoConverter getMemberShipDtoConverter;
    private final UserService userService;
    private final CompanyService companyService;

    public MemberShipService(MemberShipRepository memberShipRepository, GetMemberShipDtoConverter getMemberShipDtoConverter, UserService userService, CompanyService companyService) {
        this.memberShipRepository = memberShipRepository;
        this.getMemberShipDtoConverter = getMemberShipDtoConverter;
        this.userService = userService;
        this.companyService = companyService;
    }

    public GetMemberShipDto createMemberShip(CreateMemberShipDto createMemberShipDto) {
        MemberShip memberShip = new MemberShip();
        memberShip.setStartDate(createMemberShipDto.getStartDate());
        memberShip.setFinishDate(createMemberShipDto.getFinishDate());
        memberShip.setUser(userService.getUserById(createMemberShipDto.getUserId()));
        memberShip.setCompany(companyService.getCompanyById(createMemberShipDto.getCompanyId()));
        MemberShip savedMemberShip = memberShipRepository.save(memberShip);
        return getMemberShipDtoConverter.convert(savedMemberShip);
    }

    public List<GetMemberShipDto> getAllMemberShipsHasCompany(String companyId) {
        return memberShipRepository.findAllByCompany_Id(companyId)
                .stream()
                .map(getMemberShipDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
