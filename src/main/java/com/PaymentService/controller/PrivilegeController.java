package com.PaymentService.controller;

import com.PaymentService.dto.PrivilegeDto;
import com.PaymentService.dto.Response;
import com.PaymentService.service.PrivilegeService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.Privilege.ROOT)
public class PrivilegeController {
    private final PrivilegeService privilegeService;

    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }
    @PostMapping(UrlConstraint.Privilege.CREATE)
    public Response createPrivilege(@RequestBody PrivilegeDto privilegeDto) {
        return privilegeService.createPrivilege(privilegeDto);
    }
}
