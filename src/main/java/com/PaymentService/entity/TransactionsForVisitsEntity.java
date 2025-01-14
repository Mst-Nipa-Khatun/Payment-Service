package com.PaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Transactions")
public class TransactionsForVisitsEntity {

    @Id
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "amount")
    private Integer amount;
}
