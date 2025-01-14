package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionForVisitDto;
import com.PaymentService.entity.TransactionsForVisitsEntity;
import com.PaymentService.repository.TransactionForVisitRepository;
import com.PaymentService.service.TransactionForVisitService;
import com.PaymentService.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TransactionForVisitServiceImpl implements TransactionForVisitService {
    private final TransactionForVisitRepository transactionForVisitRepository;

    public TransactionForVisitServiceImpl(TransactionForVisitRepository transactionForVisitRepository) {
        this.transactionForVisitRepository = transactionForVisitRepository;
    }

    @Override
    public Response createTransactionForVisit(TransactionForVisitDto transactionForVisitDto) {
        TransactionsForVisitsEntity transactions=transactionForVisitRepository.findByTransactionId(transactionForVisitDto.getTransactionId());
        if(transactions==null){
            transactions=new TransactionsForVisitsEntity();
            transactions.setTransactionId(transactionForVisitDto.getTransactionId());
            transactions.setVisitId(transactionForVisitDto.getVisitId());
            transactions.setAmount(transactionForVisitDto.getAmount());
            TransactionsForVisitsEntity savedTransactions=transactionForVisitRepository.save(transactions);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,savedTransactions,"Successfully created transaction");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Transaction already exists");
    }
}
