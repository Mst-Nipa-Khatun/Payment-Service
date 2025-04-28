package com.PaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Student_Information")
public class StudentInformationTest {
    @Id
    @Column(name = "Roll")
    private Long roll;

    @Column(name = "Name")
    private String name;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "GPA")
    private Double gpa;

    @Column(name = "City")
    private String city;
}
