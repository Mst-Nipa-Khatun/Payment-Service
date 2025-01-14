package com.PaymentService.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class VisitsDto {
    @Id
    private Integer visitId;
    private Integer customerId;

}
