package com.PaymentService.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto extends BaseDto {
    private String companyName;
    private String companyAddress;
    private String companyTIN;
    private String companyOwner;
    private List<PhoneNumbersDto> phoneNumbersList;
}