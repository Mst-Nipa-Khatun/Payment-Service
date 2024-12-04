package com.PaymentService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Transaction")
@Data
public class TransactionEntity extends BaseEntity{
    private Long transactionId;
    private String transactionType;
    private Double amount;
    private String description;
    private String parentTransactionId;

}
