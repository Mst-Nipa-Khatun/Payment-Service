package com.PaymentService.service;

import com.PaymentService.dto.AmountBetweenDto;
import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionDto;

public interface TransactionService {
    Response createTransaction(TransactionDto transactionDto);
    Response getAllTransactions();
    Response getTransactionAmount();
    Response getTransactionAmountBetween();
    Response getMinMaxTransactionAmount (AmountBetweenDto amountBetweenDto);
  //  Response getTransactionAmountMinMax(Double minAmount, Double maxAmount);
}
