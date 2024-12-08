package com.PaymentService.service.Impl;

import com.PaymentService.dto.AmountBetweenDto;
import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionDto;
import com.PaymentService.entity.TransactionEntity;
import com.PaymentService.repository.TransactionRepository;
import com.PaymentService.service.TransactionService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    @Override
    public Response getAllTransactions() {
        List<TransactionEntity> transactions=transactionRepository.findAll();
        if(!transactions.isEmpty()){
            List<TransactionDto> transactionDtos=new ArrayList<>();
            for(TransactionEntity transaction:transactions){
                transactionDtos.add(modelMapper.map(transaction,TransactionDto.class));

            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,transactionDtos,"Successfully retrieved transactions");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"No transactions found");
    }

    @Override
    public Response getTransactionAmount() {
       // List<TransactionEntity> transactions=transactionRepository.findAllByStatus(1);
        List<TransactionEntity> transactions=transactionRepository.findByAmountLessThanEqualAndStatus(1000.0,1);
        if(!transactions.isEmpty()){
            List<TransactionDto> transactionDtos=new ArrayList<>();
            for(TransactionEntity transaction:transactions){
                transactionDtos.add(modelMapper.map(transaction,TransactionDto.class));

            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,transactionDtos,
                    "Successfully retrieved transactions");
        }

        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "No transactions found");
    }

    @Override
    public Response getTransactionAmountBetween() {
        List<TransactionEntity> transactionEntities=transactionRepository.findAllByStatus(1);
        if(!transactionEntities.isEmpty()){
            List<TransactionDto> transactionDtos=new ArrayList<>();
            for(TransactionEntity transaction:transactionEntities){
                if (Objects.isNull(transaction.getAmount())) {
                    continue;
                }
                Double amount=transaction.getAmount();
                if(amount>=500 && amount<=1000 ){
                    transactionDtos.add(modelMapper.map(transaction,TransactionDto.class));
                   // break;
                }
            }
            if (transactionDtos.isEmpty()) {
                return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                        "No Users Found");
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,transactionDtos,
                    "Successfully retrieved transactions");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "No transactions found");
    }

    @Override
    public Response getMinMaxTransactionAmount(AmountBetweenDto amountBetweenDto) {
        if (amountBetweenDto == null || amountBetweenDto.getMinAmount() == null || amountBetweenDto.getMaxAmount() == null) {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                    "Invalid input: minAmount and maxAmount are required");
        }

        Double minAmount = amountBetweenDto.getMinAmount();
        Double maxAmount = amountBetweenDto.getMaxAmount();

    List<TransactionEntity> transactionEntities = transactionRepository.findAllByStatus(1);
    if (!transactionEntities.isEmpty()) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (TransactionEntity transaction : transactionEntities) {
            if (transaction.getAmount() == null) {
                continue;
            }
            Double amount = transaction.getAmount();
            if (amount >= minAmount && amount <= maxAmount) {
                transactionDtos.add(modelMapper.map(transaction, TransactionDto.class));
            }
        }
        if (transactionDtos.isEmpty()) {
            return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                    "No transactions found in the given range");
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, transactionDtos,
                "Successfully retrieved transactions");
    }
    return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
            "No transactions found");

    }

//    @Override
//    public Response getTransactionAmountMinMax(Double minAmount, Double maxAmount) {
//        if (minAmount == null || maxAmount == null) {
//        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
//                "Invalid amount range provided");
//         }
//        List<TransactionEntity> transactionEntities = transactionRepository.findAllByStatus(1);
//        if (!transactionEntities.isEmpty()) {
//            List<TransactionDto> transactionDtos = new ArrayList<>();
//            for (TransactionEntity transaction : transactionEntities) {
//                if (transaction.getAmount() == null) {
//                    continue;
//                }
//                Double amount = transaction.getAmount();
//                if (amount >= minAmount && amount <= maxAmount) {
//                    transactionDtos.add(modelMapper.map(transaction, TransactionDto.class));
//                }
//            }
//            if (transactionDtos.isEmpty()) {
//                return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
//                        "No transactions found in the given range");
//            }
//            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, transactionDtos,
//                    "Successfully retrieved transactions");
//        }
//        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
//                "No transactions found");
//    }
}














































