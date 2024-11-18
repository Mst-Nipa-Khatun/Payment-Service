package com.PaymentService.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@Data
@MappedSuperclass
public class BaseDto {
    protected Long id;
}
