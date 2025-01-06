package com.PaymentService.service.Impl;

import com.PaymentService.dto.BalanceDto;
import com.PaymentService.dto.Response;
import com.PaymentService.entity.BalanceEntity;
import com.PaymentService.repository.BalanceRepository;
import com.PaymentService.service.BalanceService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;
    private final ModelMapper modelMapper;

    public BalanceServiceImpl(BalanceRepository balanceRepository, ModelMapper modelMapper) {
        this.balanceRepository = balanceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createBalance(BalanceDto balanceDto) {
        BalanceEntity balance=balanceRepository.findByBalanceAndStatus(balanceDto.getBalance(),1);
        if(balance==null){
            balance=modelMapper.map(balanceDto, BalanceEntity.class);
            balance.setStatus(1);
            balanceRepository.save(balance);
            BalanceDto createdBalanceDto=modelMapper.map(balance, BalanceDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,createdBalanceDto,"Successfully Created Balance");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Balance already exists");
    }
}
