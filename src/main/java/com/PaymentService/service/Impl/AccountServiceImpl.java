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

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Response getAllAccount() {
        List<AccountEntity> accountEntities=accountRepository.findAllByAndStatus(1);
        if(!accountEntities.isEmpty()){
            List<AccountDto> accountDtos=new ArrayList<>();
            for(AccountEntity accountEntity:accountEntities){
                AccountDto accountDto=modelMapper.map(accountEntity,AccountDto.class);
                accountDtos.add(accountDto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,accountDtos,"Get All Account");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"No account found");
    }

    @Override
    public Response getAccountById(Long id) {
        AccountEntity account=accountRepository.findByIdAndStatus(id,1);
        if(account !=null){
            account.setAccName(""+account.getAccNumber());
            account.setAccNumber(account.getAccNumber());
            account.setRegion(account.getRegion());
            account.setAccType(account.getAccType());
            AccountEntity accountEntity=accountRepository.save(account);

           // AccountDto accountDto=modelMapper.map(account,AccountDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,accountEntity,"Get Account");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"No account found");
    }
}
