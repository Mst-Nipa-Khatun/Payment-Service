package com.PaymentService.service;

import com.PaymentService.dto.BalanceDto;
import com.PaymentService.dto.Response;

public interface BalanceService {
    Response createBalance(BalanceDto balanceDto);
    Response getAllBalance();
    Response getBalanceById(Long id);
    Response deleteBalanceById(Long id);
    Response editBalanceById(Long id, BalanceDto balanceDto);
}
