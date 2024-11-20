package com.PaymentService.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsersDto extends BaseDto{
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private Integer userType;
    private Long companyId;

    private List<PhoneNumbersDto> phoneNumbersList;
    private List<RoleEntityDto> roleList;
}
