package com.coding.fitness.controller;

import com.coding.fitness.dto.CreateCompanyDto;
import com.coding.fitness.dto.GetCompanyDto;
import com.coding.fitness.service.CompanyService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<GetCompanyDto> createCompany(@RequestBody CreateCompanyDto createCompanyDto) {
        return ResponseEntity.ok(companyService.createCompany(createCompanyDto));
    }

    @GetMapping("/getAllCompanies")
    public ResponseEntity<List<GetCompanyDto>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/getAllCompaniesByName")
    public ResponseEntity<List<GetCompanyDto>> getAllCompaniesByName(@RequestParam String name) {
        return ResponseEntity.ok(companyService.getAllCompanyByName(name));
    }
}
