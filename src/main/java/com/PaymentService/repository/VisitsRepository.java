package com.PaymentService.repository;

import com.PaymentService.dto.UserDetailsProjection;
import com.PaymentService.dto.VisitsDetailsProjection;
import com.PaymentService.entity.VisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitsRepository extends JpaRepository<VisitsEntity, Integer> {
    VisitsEntity findByVisitId(Integer visitId);

    @Query(value = "SELECT customer_id , COUNT(*) as count_no_trans\n" +
            "FROM Visits\n" +
            "WHERE visit_id NOT IN (SELECT DISTINCT visit_id FROM Transactions)\n" +
            "GROUP BY customer_id", nativeQuery = true)
    List<VisitsDetailsProjection> findByVisitsAndNoTransaction();

}
