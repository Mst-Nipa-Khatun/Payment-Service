package com.PaymentService.repository;

import com.PaymentService.entity.TransactionsForVisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionForVisitRepository extends JpaRepository<TransactionsForVisitsEntity,Integer> {

    TransactionsForVisitsEntity findByTransactionId(Integer transactionId);
    List<TransactionsForVisitsEntity> findByVisitId(Integer visitId);
    //List<TransactionsForVisitsEntity> findByTransactionId();
    List<TransactionsForVisitsEntity> findAllBy();

}
