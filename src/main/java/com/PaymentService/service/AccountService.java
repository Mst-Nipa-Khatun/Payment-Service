package com.PaymentService.service;

import com.PaymentService.dto.AccountDto;
import com.PaymentService.dto.Response;

public interface AccountService {
    Response createAccount(AccountDto accountDto);
    Response getAllAccount();
    Response getAccountById(Long id);
}
