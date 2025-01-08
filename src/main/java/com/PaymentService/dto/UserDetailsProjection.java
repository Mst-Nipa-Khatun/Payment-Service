package com.PaymentService.dto;

import java.math.BigDecimal;

public interface UserDetailsProjection {
    Integer getUserId();
    String getUserName();
    BigDecimal getBalance();
    BigDecimal getLienBalance();
    String getAccNumber();
}
