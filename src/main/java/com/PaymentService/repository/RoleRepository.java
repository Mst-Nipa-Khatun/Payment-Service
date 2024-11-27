package com.PaymentService.repository;

import com.PaymentService.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByNameAndStatus(String name, Integer status);
    List<RoleEntity> findAllByUserIdAndStatus(Long userId, Integer status);
    RoleEntity findByIdAndStatus(Long id, Integer status);
}
