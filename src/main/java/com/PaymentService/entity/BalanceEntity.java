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
    @Id
    @Column(name = "Balance")
    private double balance;
    @Column(name = "Currency")
    private String currency;
    @Column(name = "LioBalance")
    private String lioBalance;
    @Column(name = "Account")
    private String account;
}
