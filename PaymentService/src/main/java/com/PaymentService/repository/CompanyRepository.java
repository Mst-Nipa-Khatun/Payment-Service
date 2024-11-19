package com.PaymentService.repository;

import com.PaymentService.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {
    CompanyEntity findByCompanyNameAndStatus(String name,Integer status);

    //ekhane to ar active entity te nai eta ekhon status diye amra replace koreci right ?hm

}
