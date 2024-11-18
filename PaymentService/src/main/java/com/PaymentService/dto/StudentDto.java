package com.PaymentService.dto;

import lombok.Data;

@Data
public class StudentDto extends BaseDto{
    private String name;
    private String gender;
    private Integer age;
}
