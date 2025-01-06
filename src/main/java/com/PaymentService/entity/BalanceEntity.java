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
//    balance double,
//    effectiveBalance double,
//    lienBalance double,
//    currency double,
//    status int,
//    userId int,
//    accountId int
    @Id
    @Column(name = "balance")
    private double balance;

    @Column(name = "effectiveBalance")
    private double effectiveBalance;

    @Column(name = "lienBalance")
    private double lienBalance;

    @Column(name = "currency")
    private double currency;

    @Column(name = "userId")
    private int userId;

    @Column(name = "accountId")
    private int accountId;
}
