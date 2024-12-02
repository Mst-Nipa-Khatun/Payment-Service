package com.PaymentService.dto;

import lombok.Data;

@Data
public class EmailAndPasswordDto {
    private Long userId;
    private String email;
    private String password;

}
