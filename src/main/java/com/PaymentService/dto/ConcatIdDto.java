package com.PaymentService.dto;

import lombok.Data;

@Data
public class ConcatIdDto extends BaseDto{
    private Long userId;
    private Long roleId;
}
