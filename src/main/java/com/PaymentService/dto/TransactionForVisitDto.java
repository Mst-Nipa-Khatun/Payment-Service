package com.PaymentService.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class TransactionForVisitDto {
    @Id
    private Integer transactionId;
    private Integer visitId;
    private Integer amount;

}
