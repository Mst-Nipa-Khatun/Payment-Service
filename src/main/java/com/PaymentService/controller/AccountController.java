package com.PaymentService.controller;

import com.PaymentService.dto.AccountDto;
import com.PaymentService.dto.Response;
import com.PaymentService.service.AccountService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.Account.ROOT)
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(UrlConstraint.Account.CREATE)
    public Response createAccount(@RequestBody AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }
}
