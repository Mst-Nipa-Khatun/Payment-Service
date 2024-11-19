package com.PaymentService.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto extends BaseDto {
    private String companyName;
    private String companyAddress;
    private String companyTIN;///same namne and data type dite hobe as entity na hole map korte parbe na arro jhamela ase...eita to jano ??h
    private String companyOwner;
    private List<PhoneNumbersDto> phoneNumbersList;//so eita o ante hob....ekhon ekhane PhoneNumbers to entity but amra to dto create kortechi right ?hmm}
}