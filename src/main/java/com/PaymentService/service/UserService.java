package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.UsersDto;

public interface UserService {
    Response createUsers(UsersDto usersDto);
    Response getAllUsers();
}
