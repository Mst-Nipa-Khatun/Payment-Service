package com.PaymentService.service;

import com.PaymentService.dto.*;

public interface UserService {
    Response createUsers(UsersDto usersDto);
    Response getAllUsers();
    Response getUserById(Long id);
    Response deleteUserById(Long id);
    Response editUserById(Long id, UsersDto usersDto);
    Response assignRoleToUser(ConcatIdDto concatIdDto);
    Response editMailAndPassword(EmailAndPasswordDto emailAndPasswordDto);
    Response getVowelUsers();
    Response getDistinctUsers(String fullName, String userName);
    Response getUsernameLike(String pattern);
    Response getUsersDetails();
    Response getUsersDetailsTwo();
}
