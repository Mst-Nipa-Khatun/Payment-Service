package com.PaymentService.controller;

import com.PaymentService.dto.AccountDto;
import com.PaymentService.dto.Response;
import com.PaymentService.service.AccountService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(UrlConstraint.Account.GET_ALL)
    public Response getAllAccounts() {
        return accountService.getAllAccount();
    }
    @GetMapping(UrlConstraint.Account.GET_ACCOUNT_BY_ID)
    public Response getAccountById(@PathVariable("id") long id) {
        return accountService.getAccountById(id);
    }
}
