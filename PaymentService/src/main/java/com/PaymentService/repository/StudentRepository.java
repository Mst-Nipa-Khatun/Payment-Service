package com.PaymentService.repository;

import com.PaymentService.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    StudentEntity findByNameAndActiveTrue(String name);

}
