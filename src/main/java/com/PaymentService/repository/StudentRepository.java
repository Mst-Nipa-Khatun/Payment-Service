package com.PaymentService.repository;

import com.PaymentService.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    StudentEntity findByNameAndStatus(String name,Integer status);

    List<StudentEntity> findAllByStatus(Integer status);

    StudentEntity findByIdAndStatus(long id,Integer status);

    List<StudentEntity> findByAgeIsNullAndStatus(Integer status);
    List<StudentEntity> findByAgeOrderByGenderDesc(Integer age);

}
