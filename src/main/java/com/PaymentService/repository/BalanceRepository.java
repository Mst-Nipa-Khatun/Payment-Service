package com.PaymentService.repository;

import com.PaymentService.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository <BalanceEntity,Long> {
    BalanceEntity findByBalanceAndStatus(Double balance, Integer status);
}
