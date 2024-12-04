package com.PaymentService.repository;

import com.PaymentService.entity.TransactionEntity;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    TransactionEntity findByTransactionIdAndStatus(Long transactionId, Integer status);
   // TransactionEntity findByTransactionId(Long transactionId);
}
