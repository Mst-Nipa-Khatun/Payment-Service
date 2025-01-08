package com.PaymentService.controller;

import com.PaymentService.dto.UserDetailsProjection;
import com.PaymentService.repository.BalanceRepository;
import com.PaymentService.repository.StudentInformationTestRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StudentInformationTestController {

    private final StudentInformationTestRepo studentInformationTestRepo;
    private final BalanceRepository balanceRepository;

    public StudentInformationTestController(StudentInformationTestRepo studentInformationTestRepo, BalanceRepository balanceRepository) {
        this.studentInformationTestRepo = studentInformationTestRepo;
        this.balanceRepository = balanceRepository;
    }

    @GetMapping("/testData")
    public List<Map<String, Object>> getTestData(){
        return balanceRepository.findByDetails();
    }
    @GetMapping("/testData2")
    public List<UserDetailsProjection> findByDetails2ndApproach(){
        return balanceRepository.findByDetails2ndApproach();
    }
}
