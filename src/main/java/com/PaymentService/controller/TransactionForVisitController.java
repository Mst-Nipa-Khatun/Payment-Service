package com.PaymentService.controller;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionForVisitDto;
import com.PaymentService.service.TransactionForVisitService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.TransactionForVisits.ROOT)
public class TransactionForVisitController {

    private final TransactionForVisitService transactionForVisitService;

    public TransactionForVisitController(TransactionForVisitService transactionForVisitService) {
        this.transactionForVisitService = transactionForVisitService;

    }
    @PostMapping(UrlConstraint.TransactionForVisits.CREATE)
    public Response createTransactionForVisit(@RequestBody TransactionForVisitDto transactionForVisitDto) {
        return transactionForVisitService.createTransactionForVisit(transactionForVisitDto);
    }
}
