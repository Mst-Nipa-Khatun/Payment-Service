package com.PaymentService.repository;

import com.PaymentService.entity.VisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitsRepository extends JpaRepository<VisitsEntity, Integer> {
}
