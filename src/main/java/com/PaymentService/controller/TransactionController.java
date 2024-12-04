package com.PaymentService.controller;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionDto;
import com.PaymentService.service.TransactionService;
import com.PaymentService.utils.UrlConstraint;
import jakarta.transaction.Transaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConstraint.Transaction.ROOT)
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping(UrlConstraint.Transaction.CREATE)
    public Response createTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.createTransaction(transactionDto);

    }
}
