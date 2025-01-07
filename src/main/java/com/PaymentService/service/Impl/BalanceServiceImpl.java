package com.PaymentService.service.Impl;

import com.PaymentService.dto.BalanceDto;
import com.PaymentService.dto.Response;
import com.PaymentService.entity.BalanceEntity;
import com.PaymentService.entity.UsersEntity;
import com.PaymentService.repository.BalanceRepository;
import com.PaymentService.repository.UsersRepository;
import com.PaymentService.service.BalanceService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;
    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository, ModelMapper modelMapper, UsersRepository usersRepository) {
        this.balanceRepository = balanceRepository;
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }

    @Override
    public Response createBalance(BalanceDto balanceDto) {
        //user table theke id onujay khujlam actualy user ase kina,jodi na thake then not found,otherwise
        //jodi thake tahole oi user k balance table e ase kina abr user id diye balance table e khjte hobe.

        UsersEntity usersEntity=usersRepository.findByIdAndStatus(balanceDto.getUserId(),1);
        if(usersEntity==null){
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"User not found");
        }
        /*ekhane userId diye khujte hobe not balance in balance table*/
       // BalanceEntity balance=balanceRepository.findByBalanceAndStatus(balanceDto.getBalance(),1);

        BalanceEntity balance=balanceRepository.findByUserIdAndStatus(balanceDto.getUserId(),1);
        if(balance==null){
            balance=new BalanceEntity();
            balance.setStatus(1);
            balance.setBalance(balanceDto.getBalance());
            balance.setEffectiveBalance(balanceDto.getEffectiveBalance());
            balance.setLienBalance(balanceDto.getLienBalance());
            balance.setCurrency(balanceDto.getCurrency());
            balance.setAccountId(balanceDto.getAccountId());
            balance.setUserId(balanceDto.getUserId());

            BalanceEntity savedBalanced=balanceRepository.save(balance);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,savedBalanced,
                    "Successfully Created Balance");
        }

        balance.setBalance(balance.getBalance()+balanceDto.getBalance());

        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "Balance already exists");
    }
}
