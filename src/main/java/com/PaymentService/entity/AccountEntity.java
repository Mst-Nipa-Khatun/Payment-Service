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

    @Column(name = "accName")
    private String accName;

    @Column(name = "accNumber")
    private String accNumber;

    @Column(name = "region")
    private String region;

    @Column(name = "accType")
    private Integer accType;
}
