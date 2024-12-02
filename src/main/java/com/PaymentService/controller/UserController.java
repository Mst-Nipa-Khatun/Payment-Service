package com.PaymentService.controller;

import com.PaymentService.dto.*;
import com.PaymentService.service.UserService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstraint.Users.ROOT)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }
    @PostMapping(UrlConstraint.Users.CREATE)
    public Response createUsers(@RequestBody UsersDto usersDto) {
        return userService.createUsers(usersDto);
    }
    @GetMapping(UrlConstraint.Users.GET_ALL)
    public Response getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping(UrlConstraint.Users.GET_USER_BY_ID)
    public Response getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
    @DeleteMapping(UrlConstraint.Users.DELETE_USER_BY_ID)
    public Response deleteUserById(@PathVariable("id") Long id) {
        return userService.deleteUserById(id);
    }
    @PutMapping(UrlConstraint.Users.EDIT_USER_BY_ID)
    public Response editUserById(@PathVariable("id") Long id, @RequestBody UsersDto usersDto) {
        return userService.editUserById(id,usersDto);
    }
    @PostMapping(UrlConstraint.Users.ASSIGN_ROLE_TO_USER)
    public Response getRoleByUserId(@RequestBody ConcatIdDto concatIdDto) {
        return userService.assignRoleToUser(concatIdDto);
    }
    @PutMapping(UrlConstraint.Users.EDIT_EMAIL_AND_PASSWORD)
    public Response editMailAndPassword(@RequestBody EmailAndPasswordDto emailAndPasswordDto) {
        return userService.editMailAndPassword(emailAndPasswordDto);
    }
    @GetMapping(UrlConstraint.Users.GET_USER_ROLE_BY_NAME)
    public Response getUserAndRoleByName(@RequestBody UserNameAndRoleDto userNameAndRoleDto) {
        return userService.getUserAndRoleName(userNameAndRoleDto);
    }

}
