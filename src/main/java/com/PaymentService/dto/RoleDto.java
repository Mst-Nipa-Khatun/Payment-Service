package com.PaymentService.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDto extends BaseDto{
    private String name;
    private Long userId;


    private List<PrivilegeDto> privilegeList;
}
