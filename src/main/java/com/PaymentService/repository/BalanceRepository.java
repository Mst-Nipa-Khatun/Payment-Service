package com.PaymentService.repository;

import com.PaymentService.dto.UserDetailsProjection;
import com.PaymentService.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BalanceRepository extends JpaRepository <BalanceEntity,Long> {

    BalanceEntity findByUserIdAndStatus(Long userId, Integer status);
    List<BalanceEntity> findAllByStatus(Integer status);
    BalanceEntity findByIdAndStatus(Long id, Integer status);

    @Query(value = "select u.user_name, b.balance, b.userId, b.lienBalance, a.acc_number\n" +
            "from balance b\n" +
            "         join users u ON u.id = b.userId\n" +
            "         join account a on a.userId = u.id", nativeQuery = true)
    List<Map<String, Object>> findByDetails();

    @Query(value = "select u.user_name as userName, b.balance, b.userId, b.lienBalance, a.acc_number as accNumber " +
            "from balance b " +
            "join users u ON u.id = b.userId " +
            "join account a on a.userId = u.id", nativeQuery = true)
    List<UserDetailsProjection> findByDetails2ndApproach();//just for example.


}
