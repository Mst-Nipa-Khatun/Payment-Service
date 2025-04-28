package com.PaymentService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Students")
public class StudentEntity extends BaseEntity{
    private String name;
    private String gender;
    private Integer age;
}
