package com.PaymentService.dto;

import lombok.Data;

@Data
public class BalanceDto extends BaseDto{
    private Double balance;
    private Double effectiveBalance;
    private Double lienBalance;
    private String currency;//BDT,USD
    private Long userId;
    private Long accountId;

}
