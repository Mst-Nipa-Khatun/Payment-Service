package com.PaymentService.repository;

import com.PaymentService.dto.CompanyDto;
import com.PaymentService.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {
    CompanyEntity findByCompanyNameAndStatus(String name,Integer status);
    List<CompanyEntity> findAllByStatus(Integer status);
    CompanyEntity findByIdAndStatus(Long id,Integer status);

}
