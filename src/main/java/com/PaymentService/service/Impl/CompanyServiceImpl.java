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

import java.util.ArrayList;
import java.util.List;

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
            company.setStatus(1);
            CompanyEntity savedCompany=companyRepository.save(company);
            CompanyDto convertedCompanyDto=modelMapper.map(savedCompany,CompanyDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,convertedCompanyDto,
                    "Company created successfully");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "Company already exists");
    }

    @Override
    public Response getAllCompanies() {
        List<CompanyEntity> company=companyRepository.findAllByStatus(1);
        if(!company.isEmpty()){
            List<CompanyDto> companyDtos=new ArrayList<>();
            for(CompanyEntity companyEntity:company){
                CompanyDto findCompany=modelMapper.map(companyEntity,CompanyDto.class);
                companyDtos.add(findCompany);

            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,companyDtos,
                    "Company found");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "No company found");
    }

    @Override
    public Response getCompanyById(Long id) {
        CompanyEntity company=companyRepository.findByIdAndStatus(id,1);
        if(company!=null){
            CompanyDto companyDto=modelMapper.map(company,CompanyDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,companyDto,
                    "Company found");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "No company found");
    }

    @Override
    public Response deleteCompanyById(Long id) {
        CompanyEntity company=companyRepository.findByIdAndStatus(id,1);
        if(company!=null){
            company.setStatus(0);
            CompanyEntity savedCompany=companyRepository.save(company);
            CompanyDto convertedCompanyDto=modelMapper.map(savedCompany,CompanyDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,convertedCompanyDto,
                    "Company Successfully deleted");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No company found");
    }

    @Override
    public Response editCompanyById(Long id, CompanyDto companyDto) {
        CompanyEntity company=companyRepository.findByIdAndStatus(id,1);
        if(company!=null){
            company=modelMapper.map(companyDto,CompanyEntity.class);
            company.setStatus(1);
            CompanyEntity savedCompany=companyRepository.save(company);
            CompanyDto convertedCompanyDto=modelMapper.map(savedCompany,CompanyDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,convertedCompanyDto,
                    "Company Edited successfully");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No company found");
    }
}
