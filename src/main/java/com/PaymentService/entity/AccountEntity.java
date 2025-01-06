package com.PaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Account")
public class AccountEntity extends BaseEntity{
//    accName varchar(20),
//    accNumber double,
//    status int,
//    region varchar(15),
//    accType varchar(15)
    @Id
    @Column(name = "accName")
    private String accName;

    @Column(name = "accNumber")
    private double accNumber;

    @Column(name = "region")
    private String region;

    @Column(name = "accType")
    private String accType;
}
