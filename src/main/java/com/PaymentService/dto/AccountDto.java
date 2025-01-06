package com.PaymentService.dto;

import lombok.Data;

@Data
public class AccountDto extends BaseDto{
    private String accName;
    private Double accNumber;
    private String region;
    private String accType;

}
