package com.PaymentService.service;

import com.PaymentService.dto.PrivilegeDto;
import com.PaymentService.dto.Response;
import com.PaymentService.utils.UrlConstraint;

public interface PrivilegeService {
    Response createPrivilege(PrivilegeDto privilegeDto);
}
