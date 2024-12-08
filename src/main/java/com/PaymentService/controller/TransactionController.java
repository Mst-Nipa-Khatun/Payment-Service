package com.PaymentService.controller;

import com.PaymentService.dto.AmountBetweenDto;
import com.PaymentService.dto.Response;
import com.PaymentService.dto.TransactionDto;
import com.PaymentService.service.TransactionService;
import com.PaymentService.utils.UrlConstraint;
import jakarta.transaction.Transaction;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(UrlConstraint.Transaction.GET_ALL)
    public Response getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    @GetMapping(UrlConstraint.Transaction.GET_TRANSACTION_AMOUNT)
    public Response getTransactionAmount() {
        return transactionService.getTransactionAmount();
}

  @GetMapping(UrlConstraint.Transaction.GET_AMOUNT_BETWEEN)
  public Response getTransactionAmountBetween() {
        return transactionService.getTransactionAmountBetween();
  }

//@GetMapping(UrlConstraint.Transaction.GET_MIN_MAX_AMOUNT)
//    public Response getMinMaxTransactionAmount(@RequestBody AmountBetweenDto amountBetweenDto) {
//    return transactionService.getMinMaxTransactionAmount(amountBetweenDto);
//}

@GetMapping(UrlConstraint.Transaction.GET_MIN_MAX_AMOUNT)
    public Response getTransactionAmountMinMax(@RequestBody Double minAmount, Double maxAmount) {
        return transactionService.getTransactionAmountMinMax(minAmount,maxAmount);
}

}
