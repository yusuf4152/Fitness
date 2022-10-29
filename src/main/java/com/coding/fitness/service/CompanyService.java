package com.coding.fitness.service;

import com.coding.fitness.dto.CreateCompanyDto;
import com.coding.fitness.dto.GetCompanyDto;
import com.coding.fitness.dto.converter.GetCompanyDtoConverter;
import com.coding.fitness.entity.Company;
import com.coding.fitness.repository.CompanyRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final GetCompanyDtoConverter getCompanyDtoConverter;

    public CompanyService(CompanyRepository companyRepository, GetCompanyDtoConverter getCompanyDtoConverter) {
        this.companyRepository = companyRepository;
        this.getCompanyDtoConverter = getCompanyDtoConverter;
    }

    public GetCompanyDto createCompany(CreateCompanyDto createCompanyDto) {
        Company company = new Company();
        company.setName(createCompanyDto.getName());
        company.setAddress(createCompanyDto.getAddress());
        company.setPhoneNumber(createCompanyDto.getPhoneNumber());
        Company savedCompany = companyRepository.save(company);
        return getCompanyDtoConverter.convert(savedCompany);
    }

    public List<GetCompanyDto> getAllCompanies(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAll(pageable).get()
                .map(getCompanyDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
