package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.StudentDto;

public interface StudentService {
     Response createStudent(StudentDto studentDto);
     Response getAllStudent();
     Response getPaymentById(Long id);
     Response deleteById(Long id);
     Response editPaymentById(Long id, StudentDto studentDto);
     Response getNullAge();
     Response getAgeByGenderDesc(Integer age);
}
