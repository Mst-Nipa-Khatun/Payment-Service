package com.PaymentService.controller;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleDto;
import com.PaymentService.service.RoleService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstraint.Roles.ROOT)
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping(UrlConstraint.Roles.CREATE)
    public Response createRole(@RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }
    @GetMapping(UrlConstraint.Roles.GET_ALL_By_RoleId)
    public Response getAllRolesByUserId(@RequestParam("userId") Long userId) {
        return roleService.getAllRoleByUserId(userId);
    }

}
