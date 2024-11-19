package com.PaymentService.service;

import com.PaymentService.dto.CompanyDto;
import com.PaymentService.dto.Response;

public interface CompanyService {
    Response createCompany(CompanyDto companyDto);
    Response getAllCompanies();
    Response getCompanyById(Long id);
    Response deleteCompanyById(Long id);
    Response editCompanyById(Long id, CompanyDto companyDto);
}
