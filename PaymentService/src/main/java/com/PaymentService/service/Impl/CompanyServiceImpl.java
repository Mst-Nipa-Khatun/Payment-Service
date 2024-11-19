package com.PaymentService.service.Impl;

import com.PaymentService.dto.CompanyDto;
import com.PaymentService.dto.Response;
import com.PaymentService.entity.CompanyEntity;
import com.PaymentService.repository.CompanyRepository;
import com.PaymentService.service.CompanyService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createCompany(CompanyDto companyDto) {
        CompanyEntity company=companyRepository.findByCompanyNameAndStatus(companyDto.getCompanyName(),1);
        if(company==null){
            company=modelMapper.map(companyDto,CompanyEntity.class);
            company.setStatus(1);//here 1 means active bole amra dhore nibo...understand? hmm
            CompanyEntity savedCompany=companyRepository.save(company);
            CompanyDto convertedCompanyDto=modelMapper.map(savedCompany,CompanyDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,convertedCompanyDto,
                    "Company created successfully");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "Company already exists");
    }
}
