package com.PaymentService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UsersEntity extends BaseEntity {
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private Integer userType;
    private Integer numberOfBadLogin;
    private Long companyId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhoneNumbers> phoneNumbersList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RoleEntity> roleEntityList;


    @Override
    public void preSave() {
        super.preSave();
        this.numberOfBadLogin = 0;
    }
}

