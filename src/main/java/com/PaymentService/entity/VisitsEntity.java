package com.PaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Visits")
public class VisitsEntity {

    @Id
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "customer_id")
    private Integer customerId;
}
