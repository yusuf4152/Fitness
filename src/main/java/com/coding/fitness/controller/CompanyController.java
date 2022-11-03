package com.coding.fitness.controller;

import com.coding.fitness.dto.requests.CreateCompanyDto;
import com.coding.fitness.dto.requests.UpdateCompanyDto;
import com.coding.fitness.dto.responses.GetCompanyDto;
import com.coding.fitness.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/createCompany")
    public ResponseEntity<GetCompanyDto> createCompany(@Valid @RequestBody CreateCompanyDto createCompanyDto) {
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

    @PutMapping("/updateCompany")
    public ResponseEntity<GetCompanyDto> updateCompany(@Valid @RequestBody UpdateCompanyDto updateCompanyDto) {
        return ResponseEntity.ok(companyService.updateCompany(updateCompanyDto));
    }
}
