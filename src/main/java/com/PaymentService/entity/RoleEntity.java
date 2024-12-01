package com.PaymentService.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "role")
public class RoleEntity extends BaseEntity {
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PrivilegeEntity> privilegeEntityList;
}
