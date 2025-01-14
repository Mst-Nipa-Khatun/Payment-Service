package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionForVisitDto;

public interface TransactionForVisitService {
    Response createTransactionForVisit(TransactionForVisitDto transactionForVisitDto);
}
