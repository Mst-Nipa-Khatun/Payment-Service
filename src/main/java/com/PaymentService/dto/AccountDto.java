package com.PaymentService.dto;

import lombok.Data;

@Data
public class AccountDto extends BaseDto{
    private String accName;
    private String accNumber;
    private String region;
    private Integer accType;

}
