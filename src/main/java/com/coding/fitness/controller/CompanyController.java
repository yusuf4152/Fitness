package com.coding.fitness.controller;

import com.coding.fitness.dto.CreateCompanyDto;
import com.coding.fitness.dto.GetCompanyDto;
import com.coding.fitness.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/createCompany")
    public GetCompanyDto createCompany(@RequestBody CreateCompanyDto createCompanyDto) {
        return companyService.createCompany(createCompanyDto);
    }

    @GetMapping(value = "/getAllCompanies")
    public List<GetCompanyDto> getAllCompanies(@RequestParam(name = "page", defaultValue = "1") int page,
                                               @RequestParam(name = "size", defaultValue = "10") int size) {
        return companyService.getAllCompanies(page, size);
    }
}
