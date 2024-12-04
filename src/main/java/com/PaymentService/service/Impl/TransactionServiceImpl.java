package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionDto;
import com.PaymentService.entity.TransactionEntity;
import com.PaymentService.repository.TransactionRepository;
import com.PaymentService.service.TransactionService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createTransaction(TransactionDto transactionDto) {
        TransactionEntity transaction=transactionRepository.findByTransactionIdAndStatus(transactionDto.getTransactionId(),1);
        if(transaction==null){
            transaction=modelMapper.map(transactionDto,TransactionEntity.class);
            transaction.setStatus(1);
            TransactionEntity savedTransaction= transactionRepository.save(transaction);
            TransactionDto savedTransactionDto=modelMapper.map(savedTransaction,TransactionDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,savedTransactionDto,"Successfully created transaction");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Transaction already exists");
    }
}
