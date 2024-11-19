package com.PaymentService.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "phone_numbers")
public class PhoneNumbers extends BaseEntity{
    private String phone;
}
