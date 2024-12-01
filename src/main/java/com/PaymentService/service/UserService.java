package com.PaymentService.service;

import com.PaymentService.dto.ConcatIdDto;
import com.PaymentService.dto.Response;
import com.PaymentService.dto.UsersDto;

public interface UserService {
    Response createUsers(UsersDto usersDto);
    Response getAllUsers();
    Response getUserById(Long id);
    Response deleteUserById(Long id);
    Response editUserById(Long id, UsersDto usersDto);
    Response assignRoleToUser(ConcatIdDto concatIdDto);
}
