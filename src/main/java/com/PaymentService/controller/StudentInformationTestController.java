package com.PaymentService.controller;

import com.PaymentService.repository.StudentInformationTestRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentInformationTestController {

    private final StudentInformationTestRepo studentInformationTestRepo;

    public StudentInformationTestController(StudentInformationTestRepo studentInformationTestRepo) {
        this.studentInformationTestRepo = studentInformationTestRepo;
    }

    @GetMapping("/testData")
    public Object getTestData(){
        return studentInformationTestRepo.getTestData();
    }
}
