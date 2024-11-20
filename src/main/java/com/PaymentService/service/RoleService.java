package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleDto;

public interface RoleService {
    Response createRole(RoleDto roleDto);
}
