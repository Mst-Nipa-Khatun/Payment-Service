package com.PaymentService.repository;

import com.PaymentService.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByUserNameAndStatus(String name, Integer status);
UsersEntity findByIdAndStatus(Long id, Integer status);
    //private final CompanyRepository companyRepo;
}