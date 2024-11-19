package com.PaymentService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="payment_service")
public class StudentEntity extends BaseEntity{
    private String name;
    private String gender;
    private Integer age;
}
