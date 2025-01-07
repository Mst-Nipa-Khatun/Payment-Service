package com.PaymentService.repository;

import com.PaymentService.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository <BalanceEntity,Long> {
    BalanceEntity findByUserIdAndStatus(Long userId, Integer status);
    List<BalanceEntity> findAllByStatus(Integer status);
    BalanceEntity findByIdAndStatus(Long id, Integer status);

}
