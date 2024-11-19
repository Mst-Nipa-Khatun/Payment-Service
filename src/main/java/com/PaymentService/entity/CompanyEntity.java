package com.PaymentService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "company")
public class CompanyEntity extends BaseEntity {
    private String companyName;
    private String companyAddress;
    private String companyTIN;
    private String companyOwner;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhoneNumbers> phoneNumbersList;
}
