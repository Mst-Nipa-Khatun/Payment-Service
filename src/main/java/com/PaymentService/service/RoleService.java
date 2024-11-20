package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleEntityDto;

public interface RoleService {
    Response createRole(RoleEntityDto roleEntityDto);
    Response getAllRoleByUserId(Long userId);
}
