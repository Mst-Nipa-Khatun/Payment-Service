package com.PaymentService.controller;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.StudentDto;
import com.PaymentService.service.StudentService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstraint.PaymentService.ROOT)
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping(UrlConstraint.PaymentService.CREATE)
    public Response createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);

    }
}
