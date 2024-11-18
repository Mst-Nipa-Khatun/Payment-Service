package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.StudentDto;

public interface StudentService {
     Response createStudent(StudentDto studentDto);
}
