package com.PaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BALANCE")
public class BalanceEntity extends BaseEntity{
    @Column(name = "balance")
    private Double balance;

    @Column(name = "effectiveBalance")
    private Double effectiveBalance;

    @Column(name = "lienBalance")
    private Double lienBalance;

    @Column(name = "currency")
    private Double currency;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "accountId")
    private Long accountId;
}
