package com.PaymentService.service.Impl;

import com.PaymentService.dto.AccountDto;
import com.PaymentService.dto.Response;
import com.PaymentService.entity.AccountEntity;
import com.PaymentService.repository.AccountRepository;
import com.PaymentService.service.AccountService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createAccount(AccountDto accountDto) {
        AccountEntity account=accountRepository.findByAccNameAndStatus(accountDto.getAccName(),1);
        if(account==null){
            account=new AccountEntity();
            account.setStatus(1);
            account.setAccName(accountDto.getAccName());
            account.setAccNumber(accountDto.getAccNumber());
            account.setRegion(accountDto.getRegion());
            account.setAccType(accountDto.getAccType());
            AccountEntity savedAccount=accountRepository.save(account);

            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,savedAccount,"Created");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Account already exists");
    }
}
