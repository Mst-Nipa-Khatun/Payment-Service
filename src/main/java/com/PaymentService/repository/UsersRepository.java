package com.PaymentService.repository;

import com.PaymentService.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByUserNameAndStatus(String name, Integer status);
    UsersEntity findByIdAndStatus(Long id, Integer status);//Uses RoleServiceImpl
    List<UsersEntity> findAllByStatus(Integer status);

//    UsersEntity findByEmailAndPassword(String email, String password);
//    UsersEntity findByIdAndEmailAndPassword(Long id, String email, String password);

//    @Query("select u from UsersEntity u where substring(lower(u.userName),1,1) in ('a','e','i','o','u')")
//    List<UsersEntity> findByUserNameStartingWithVowel();

    List<UsersEntity> findDistinctByUserNameAndFullNameAndStatus(String userName, String fullName, Integer status);
   List<UsersEntity> findDistinctByFullNameAndUserName(String fullName, String userName);

   List<UsersEntity> findByUserNameLikeAndStatus(String pattern, Integer status);


}