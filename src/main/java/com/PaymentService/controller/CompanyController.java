package com.PaymentService.controller;

import com.PaymentService.dto.CompanyDto;
import com.PaymentService.dto.Response;
import com.PaymentService.service.CompanyService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(UrlConstraint.Company.GET_ALL)
    public Response getAllCompanies(){
        return companyService.getAllCompanies();
    }
    @GetMapping(UrlConstraint.Company.GET_COMPANY_BY_ID)
    public Response getCompanyById(@PathVariable("id") Long id) {
       return companyService.getCompanyById(id);
    }
    @DeleteMapping(UrlConstraint.Company.DELETE_COMPANY_BY_ID)
    public Response deleteCompanyById(@PathVariable("id") Long id) {
        return companyService.deleteCompanyById(id);
    }
    @PutMapping(UrlConstraint.Company.EDIT_COMPANY_BY_ID)
    public Response editCompanyById(@PathVariable("id") Long id, @RequestBody CompanyDto companyDto) {
        return companyService.editCompanyById(id,companyDto);
    }
}
