package com.coding.fitness.service;

import com.coding.fitness.dto.requests.CreateCompanyDto;
import com.coding.fitness.dto.requests.UpdateCompanyDto;
import com.coding.fitness.dto.responses.GetCompanyDto;
import com.coding.fitness.dto.converter.GetCompanyDtoConverter;
import com.coding.fitness.entity.Company;
import com.coding.fitness.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public List<GetCompanyDto> getAllCompanies() {
        return companyRepository
                .findAll()
                .stream()
                .map(getCompanyDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public GetCompanyDto updateCompany(UpdateCompanyDto updateCompanyDto) {
        Company company = getCompanyById(updateCompanyDto.getId());
        company.setName((updateCompanyDto.getName()) == null ? company.getName() : updateCompanyDto.getName());
        company.setAddress((updateCompanyDto.getAddress()) == null ? company.getAddress() : updateCompanyDto.getAddress());
        company.setPhoneNumber((updateCompanyDto.getPhoneNumber()) == null ? company.getPhoneNumber() : updateCompanyDto.getPhoneNumber());
        return getCompanyDtoConverter.convert(companyRepository.save(company));
    }

    protected Company getCompanyById(String id) {
        return companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " company not found"));
    }

    public List<GetCompanyDto> getAllCompanyByName(String name) {
        return companyRepository
                .findAllByName(name)
                .stream()
                .map(getCompanyDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
