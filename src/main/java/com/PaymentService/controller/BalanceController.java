package com.PaymentService.controller;

import com.PaymentService.dto.BalanceDto;
import com.PaymentService.dto.Response;
import com.PaymentService.service.BalanceService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.Balance.ROOT)
public class BalanceController {
    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @PostMapping(UrlConstraint.Balance.CREATE)
    public Response createBalance(@RequestBody BalanceDto balanceDto) {
    return balanceService.createBalance(balanceDto);
}
}
