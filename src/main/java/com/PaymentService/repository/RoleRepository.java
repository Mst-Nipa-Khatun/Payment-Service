package com.PaymentService.repository;

import com.PaymentService.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNameAndStatus(String name, Integer status);
    List<Role> findAllByStatus(Integer status);
}
