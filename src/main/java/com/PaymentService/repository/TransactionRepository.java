package com.PaymentService.repository;

import com.PaymentService.entity.TransactionEntity;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    TransactionEntity findByTransactionIdAndStatus(Long transactionId, Integer status);
  List<TransactionEntity> findByAmountLessThanEqualAndStatus(Double amount, Integer status);
  List<TransactionEntity> findAllByStatus(Integer status);


//select *from Transaction where amount>=500 and amount <=1000 and status = 1;
    List<TransactionEntity> findByAmountGreaterThanEqualAndAmountLessThanEqualAndStatus(Double minAmount,
                                                                                        Double maxAmount
            , Integer status);


}
