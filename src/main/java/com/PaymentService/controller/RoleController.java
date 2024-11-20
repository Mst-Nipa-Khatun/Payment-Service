package com.PaymentService.controller;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleEntityDto;
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
    public Response createRole(@RequestBody RoleEntityDto roleEntityDto) {
        return roleService.createRole(roleEntityDto);
    }
    @GetMapping(UrlConstraint.Roles.GET_ALL_By_UserId)
    public Response getAllRolesByUserId(@RequestParam("userId") Long userId) {
        return roleService.getAllRoleByUserId(userId);
    }

}
