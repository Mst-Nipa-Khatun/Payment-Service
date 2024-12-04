package com.PaymentService.dto;

import lombok.Data;

@Data
public class TransactionDto extends BaseDto{
    private Long transactionId;
    private String transactionType;
    private Double amount;
    private String description;
    private Long parentTransactionId;
}
