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

    @Query(value = "SELECT * FROM users WHERE status = :status", nativeQuery = true)//can you write this wre ok
    List<UsersEntity> findAllByStatuswithnative(@Param("status") String status);



    ///SELECT u FROM UsersEntity  eita ki list na ki single return dibe ??????List okay
    //SELECT u FROM UsersEntity where u.status = 1 //eita ????userEntity te ststus j gulo 1. tahole List of entityt naki only entity ???list of
    // SELECT u FROM UsersEntity where u.status = 1 and u.id = 2///eita li kist naki only entity = ??only ekta

    ///okay keno only keno list na?????bcz userentity jar id no 2 take dite bolteche.r fist tay userentity
    // te status 1 sob gulo 1.list of.oiiiiiii
    @Query(value = "SELECT u FROM UsersEntity u WHERE u.status = :status")
    List<UsersEntity> findAllByStatusWithoutNative(@Param("status") String status);//good//assa ekhane  List<UsersEntity> na diye only UsersEntity dile hoto na ?????kno ami to all find kortechi,hae dite hoto [ki dite hoto???list of na die normally userentity...] karon ami to select from u userEntity te kortechi taina?

    List<UsersEntity> findAllByStatus(Integer status);



//    @Query("select u from UsersEntity u where substring(lower(u.userName),1,1) in ('a','e','i','o','u')")
//    List<UsersEntity> findByUserNameStartingWithVowel();

@Query(value = "SELECT DISTINCT *from users where fullName=:fullName and userName=:userName And status=:status", nativeQuery = true)
List<UsersEntity> findDistinctByFullNameAndUserNameNative(@Param("fullName") String fullName, @Param("userName") String userName);

   List<UsersEntity> findDistinctByFullNameAndUserName(String fullName, String userName);

   List<UsersEntity> findByUserNameLikeAndStatus(String pattern, Integer status);


}