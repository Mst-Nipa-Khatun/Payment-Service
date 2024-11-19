package com.PaymentService.controller;

import com.PaymentService.dto.CompanyDto;
import com.PaymentService.dto.Response;
import com.PaymentService.service.CompanyService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.Company.ROOT)
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping(UrlConstraint.Company.CREATE)
    public Response createCompany(@RequestBody CompanyDto companyDto) {
        return companyService.createCompany(companyDto);
    }
}
