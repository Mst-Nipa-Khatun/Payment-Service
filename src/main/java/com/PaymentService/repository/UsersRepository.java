package com.PaymentService.repository;

import com.PaymentService.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    @Query(value = "SELECT * FROM users WHERE username = :username AND status = :status", nativeQuery = true)
    UsersEntity findByUserNameAndStatusNative(@Param("userName") String userName, @Param("status") Integer status);
    UsersEntity findByUserNameAndStatus(String userName,Integer status);

    @Query(value = "select *from users where id=:id AND status=:status", nativeQuery = true)
    UsersEntity findByIdAndStatusNative(@Param("id") Long id,@Param("status") Integer status);
    UsersEntity findByIdAndStatus(Long id, Integer status);

    @Query(value = "SELECT * FROM users WHERE status = :status", nativeQuery = true)
    List<UsersEntity> findAllByStatuswithnative(@Param("status") String status);


    @Query(value = "SELECT u FROM UsersEntity u WHERE u.status = :status")
    List<UsersEntity> findAllByStatusWithoutNative(@Param("status") String status);
    List<UsersEntity> findAllByStatus(Integer status);



//    @Query("select u from UsersEntity u where substring(lower(u.userName),1,1) in ('a','e','i','o','u')")
//    List<UsersEntity> findByUserNameStartingWithVowel();

@Query(value = "SELECT DISTINCT *from users where fullName=:fullName and userName=:userName And status=:status", nativeQuery = true)
List<UsersEntity> findDistinctByFullNameAndUserNameNative(@Param("fullName") String fullName, @Param("userName") String userName);

   List<UsersEntity> findDistinctByFullNameAndUserName(String fullName, String userName);

   @Query(value = "SELECT *from users where userName=:userName LIKE 'N%'",nativeQuery=true)
   List<UsersEntity> findByUserNameLikeAndStatus(String pattern, Integer status);


}