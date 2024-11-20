package com.PaymentService.repository;

import com.PaymentService.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByUserNameAndStatus(String name, Integer status);
    UsersEntity findByIdAndStatus(Long id, Integer status);//For RoleServiceImpl
    List<UsersEntity> findAllByStatus(Integer status);
}