package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionDto;

public interface TransactionService {
    Response createTransaction(TransactionDto transactionDto);
    Response getAllTransactions();
    Response getTransactionAmount();
    Response getTransactionAmountBetween();
    Response getTransactionAmountBetweenTwoRange(Double amount,TransactionDto transactionDto);
}
