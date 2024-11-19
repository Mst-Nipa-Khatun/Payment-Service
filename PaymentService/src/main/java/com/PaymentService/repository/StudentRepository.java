package com.PaymentService.repository;

import com.PaymentService.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    StudentEntity findByNameAndStatus(String name,Integer Status);

    List<StudentEntity> findAllByStatus(Integer Status);//ki change kora lagbe ekhane sob koro rkhon
    StudentEntity findByIdAndStatus(long id,Integer Status);

}
