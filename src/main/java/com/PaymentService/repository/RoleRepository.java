package com.PaymentService.repository;

import com.PaymentService.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByNameAndStatus(String name, Integer status);
    RoleEntity findByIdAndStatus(Long id, Integer status);
    List<RoleEntity> findAllByStatus(Integer status);

//    @Query("select u from RoleEntity u where substring(lower(u.name),1,1) in ('a','e','i','o','u')")
//    List<RoleEntity> findByRoleNameStartingWithVowel();
}
