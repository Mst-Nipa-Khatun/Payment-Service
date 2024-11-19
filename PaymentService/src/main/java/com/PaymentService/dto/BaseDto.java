package com.PaymentService.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@Data
@MappedSuperclass
public class BaseDto {
    protected Long id;
    protected Integer status;///ekhane jemon entity er jonno id common status o common right?hmm ekhon j status korchi ete to 1=true eigulor jonno r ami j status likhchi vabchi ekta cmpany desingnstion sstus....no need now
}
