package com.PaymentService.repository;

import com.PaymentService.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByUserNameAndStatus(String name, Integer status);
    UsersEntity findByIdAndStatus(Long id, Integer status);//Uses RoleServiceImpl
    List<UsersEntity> findAllByStatus(Integer status);
     //UsersEntity findById(long id);
    UsersEntity findByEmailAndPassword(String email, String password);
    UsersEntity findByIdAndEmailAndPassword(Long id, String email, String password);
  //  UsersEntity findByUserNameAndVowels(String name, String vowels);

    List<UsersEntity> findByUserNameStartingWithVowel();
    List<UsersEntity> findByUserNameStartingWithVowel(String word);


    // List<RoleEntity> findByRoleNameStartingWithVowel(); //role Repo te add korte hobe
   // List<String> findByNamesStartingWithVowelFromUsersAndRoles();



}