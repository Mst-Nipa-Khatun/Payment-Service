package com.PaymentService.repository;

import com.PaymentService.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {

    AccountEntity findByAccNameAndStatus(String accName,Integer status);
    List<AccountEntity> findAllByAndStatus(Integer status);
    AccountEntity findByIdAndStatus(Long id,Integer status);
}
