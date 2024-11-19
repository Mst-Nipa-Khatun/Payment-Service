package com.PaymentService.dto;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data

public class UsersDto extends BaseDto{
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private Integer userType;
    private Integer numberOfBadLogin;
    private Integer companyId;
    private List<PhoneNumbersDto> phoneNumbersList;
}
