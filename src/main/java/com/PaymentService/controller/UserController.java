package com.PaymentService.controller;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.UsersDto;
import com.PaymentService.service.UserService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
