package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleDto;

public interface RoleService {
    Response createRole(RoleDto roleDto);
    Response getAllRoleByUserId(Long userId);
    Response getRoleById(Long id);
    Response deleteRoleById(Long id);
    Response editRoleById(Long id, RoleDto roleDto);
}
