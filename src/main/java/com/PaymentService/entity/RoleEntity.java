package com.PaymentService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "role")
@Entity
public class RoleEntity extends BaseEntity {
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PrivilegeEntity> privilegeEntityList;
}
