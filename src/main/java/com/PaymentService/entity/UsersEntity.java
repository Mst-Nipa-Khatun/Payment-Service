package com.PaymentService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="users")
public class UsersEntity extends BaseEntity{
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private Integer userType;
    private Integer numberOfBadLogin;
    private Integer companyId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhoneNumbers> phoneNumbersList;
}

