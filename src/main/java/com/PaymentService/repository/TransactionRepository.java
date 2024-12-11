package com.PaymentService.repository;

import com.PaymentService.entity.TransactionEntity;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    TransactionEntity findByTransactionIdAndStatus(Long transactionId, Integer status);

    List<TransactionEntity> findByAmountLessThanEqualAndStatus(Double amount, Integer status);

    List<TransactionEntity> findAllByStatus(Integer status);



    @Query(value = "select  *from Transaction where trim(lower(transaction_type))=lower(:transaction_type) AND amount BETWEEN :startAmount" +
            " AND :endAmount", nativeQuery = true)
    List<TransactionEntity> getSpecificDataWithNativeQuery(@Param("transaction_type") String transaction_type,
                                            @Param("startAmount") Double startAmount,
                                            @Param("endAmount") Double endAmount);


    @Query(value = "select  u from TransactionEntity u where trim(lower(u.transactionType))=lower(:transaction_type) AND u.amount BETWEEN :startAmount" +
            " AND :endAmount")
    List<TransactionEntity> getSpecificDataWithoutNativeQuery(@Param("transaction_type") String transaction_type,
                                                              @Param("startAmount") Double startAmount,
                                                              @Param("endAmount") Double endAmount);


    List<TransactionEntity> findByAmountGreaterThanEqualAndAmountLessThanEqualAndStatus(Double minAmount,
                                                                                        Double maxAmount
            , Integer status);


}
