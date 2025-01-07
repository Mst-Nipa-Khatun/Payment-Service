package com.PaymentService.controller;

import com.PaymentService.dto.BalanceDto;
import com.PaymentService.dto.Response;
import com.PaymentService.service.BalanceService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(UrlConstraint.Balance.GET_ALL)
    public Response getAllBalances() {
        return balanceService.getAllBalance();
    }
    @GetMapping(UrlConstraint.Balance.GET_BALANCE_BY_ID)
    public Response getBalanceById(@PathVariable("id") Long id) {
       return balanceService.getBalanceById(id);
    }
    @DeleteMapping(UrlConstraint.Balance.DELETE_BALANCE_BY_ID)
    public Response deleteBalanceById(@PathVariable("id") Long id) {
        return balanceService.deleteBalanceById(id);
    }
    @PutMapping(UrlConstraint.Balance.EDIT_BALANCE_BY_ID)
    public Response editBalanceById(@PathVariable("id") Long id, @RequestBody BalanceDto balanceDto) {
        return balanceService.editBalanceById(id,balanceDto);
    }
}
