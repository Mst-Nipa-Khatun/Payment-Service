package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.UsersDto;
import com.PaymentService.entity.CompanyEntity;
import com.PaymentService.entity.UsersEntity;
import com.PaymentService.repository.CompanyRepository;
import com.PaymentService.repository.UsersRepository;
import com.PaymentService.service.UserService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    public UserServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public Response createUsers(UsersDto usersDto) {
        CompanyEntity currentCompany = companyRepository.findByIdAndStatus(usersDto.getCompanyId(), 1);
        if (currentCompany == null) {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                    "Company not found by the requested companyId");
        }
        UsersEntity usersEntity = usersRepository.findByUserNameAndStatus(usersDto.getUserName(), 1);
        if (usersEntity == null) {
                usersEntity = modelMapper.map(usersDto, UsersEntity.class);
            usersEntity.setStatus(1);
            UsersEntity savedUsers = usersRepository.save(usersEntity);
            UsersDto convertUsers = modelMapper.map(savedUsers, UsersDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, convertUsers, "Successfully Created");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                "Username already exists");
    }
}
