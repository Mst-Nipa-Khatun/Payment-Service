package com.PaymentService.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "Privilege")
public class PrivilegeEntity extends BaseEntity {
    private String privilege;
}
