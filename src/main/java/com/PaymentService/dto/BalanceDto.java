package com.PaymentService.dto;

import lombok.Data;

@Data
public class BalanceDto extends BaseDto{
    private Double balance;
    private Double effectiveBalance;
    private Double lienBalance;
    private Double currency;
    private Long userId;
    private Long accountId;

}
