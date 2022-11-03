package com.coding.fitness.service;

import com.coding.fitness.dto.requests.CreateMemberShipDto;
import com.coding.fitness.dto.requests.UpdateMemberShipDto;
import com.coding.fitness.dto.responses.GetMemberShipDto;
import com.coding.fitness.dto.converter.GetMemberShipDtoConverter;
import com.coding.fitness.entity.MemberShip;
import com.coding.fitness.entity.User;
import com.coding.fitness.repository.MemberShipRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberShipService {

    private final MemberShipRepository memberShipRepository;
    private final GetMemberShipDtoConverter getMemberShipDtoConverter;
    private final UserService userService;
    private final CompanyService companyService;

    public MemberShipService(MemberShipRepository memberShipRepository, GetMemberShipDtoConverter getMemberShipDtoConverter, @Lazy UserService userService, CompanyService companyService) {
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

    public GetMemberShipDto updateMemberShip(UpdateMemberShipDto updateMemberShipDto) {
        MemberShip memberShip = getMemberShipById(updateMemberShipDto.getId());
        memberShip.setStartDate(
                (updateMemberShipDto.getStartDate() == null) ? memberShip.getStartDate() : updateMemberShipDto.getStartDate());
        memberShip.setFinishDate(
                (updateMemberShipDto.getFinishDate() == null) ? memberShip.getFinishDate() : updateMemberShipDto.getFinishDate());
        return getMemberShipDtoConverter.convert(memberShip);
    }

    protected MemberShip getMemberShipById(long id) {
        return memberShipRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
    }

    public List<GetMemberShipDto> getAllMemberShipsHasCompany(String companyId) {
        return memberShipRepository.findAllByCompany_IdAndIsActiveTrue(companyId)
                .stream()
                .map(getMemberShipDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public GetMemberShipDto getUserMemberShip(String userId) {
        User user = userService.getUserById(userId);
        MemberShip memberShip = memberShipRepository.findByUser_IdAndIsActiveTrue(user.getId());
        return getMemberShipDtoConverter.convert(memberShip);
    }

    protected void deleteMemberShipByUserId(String userId) {
        MemberShip memberShip = memberShipRepository.findByUser_IdAndIsActiveTrue(userId);
        memberShip.setActive(false);
        memberShipRepository.save(memberShip);
    }
}
