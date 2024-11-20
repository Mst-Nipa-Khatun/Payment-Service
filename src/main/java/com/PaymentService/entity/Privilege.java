package com.PaymentService.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "privilege")
public class Privilege extends BaseEntity {
    private String privilege;
}
