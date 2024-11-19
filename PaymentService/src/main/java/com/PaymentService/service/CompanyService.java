package com.PaymentService.service;

import com.PaymentService.dto.CompanyDto;
import com.PaymentService.dto.Response;

public interface CompanyService {
    Response createCompany(CompanyDto companyDto);
}
