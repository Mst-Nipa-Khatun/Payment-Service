package com.PaymentService.dto;

import lombok.Data;

@Data
public class AmountBetweenDto extends BaseDto{
    private Double minAmount;
    private Double maxAmount;
}
