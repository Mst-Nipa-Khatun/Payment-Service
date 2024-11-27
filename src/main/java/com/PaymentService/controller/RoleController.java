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

    @GetMapping(UrlConstraint.Roles.GET_ALL_ROLE_By_UserId)
    public Response getAllRolesByUserId(@PathVariable("userId") Long userId) {
        return roleService.getAllRoleByUserId(userId);
    }
    @GetMapping(UrlConstraint.Roles.GET_ROlE_BY_ID)
    public Response getRoleById(@PathVariable("id") Long id) {
        return roleService.getRoleById(id);

    }
    @DeleteMapping(UrlConstraint.Roles.DELETE_ROLE_BY_ID)
    public Response deleteRoleById(@PathVariable("id") Long id) {
        return roleService.deleteRoleById(id);

    }
    @PutMapping(UrlConstraint.Roles.EDIT_ROLE_BY_ID)
    public Response editRoleById(@PathVariable("id") Long id, @RequestBody RoleDto roleDto) {
        return roleService.editRoleById(id,roleDto);
    }


}
