package com.PaymentService.dto;

import lombok.Data;

@Data
public class UserNameAndRoleDto extends BaseDto{
    private String userName;
    private String roleName;
}
