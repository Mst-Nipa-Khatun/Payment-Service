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

import java.util.ArrayList;
import java.util.List;

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
        UsersEntity usersEntity = usersRepository.findByIdAndStatus(balanceDto.getUserId(), 1);
        if (usersEntity == null) {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null, "User not found");
        }

        BalanceEntity balance = balanceRepository.findByUserIdAndStatus(balanceDto.getUserId(), 1);
        if (balance == null) {
            balance = new BalanceEntity();
            balance.setStatus(1);
            balance.setBalance(balanceDto.getBalance());
            balance.setEffectiveBalance(balanceDto.getEffectiveBalance());
            balance.setLienBalance(balanceDto.getLienBalance());
            balance.setCurrency(balanceDto.getCurrency());
            balance.setAccountId(balanceDto.getAccountId());
            balance.setUserId(balanceDto.getUserId());

            BalanceEntity savedBalanced = balanceRepository.save(balance);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, savedBalanced,
                    "Successfully Created Balance");
        }
        balance.setBalance(balance.getBalance() + balanceDto.getBalance());
       BalanceEntity b= balanceRepository.save(balance);

        return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, b,
                "Balance already created");

    }

    @Override
    public Response getAllBalance() {
        List<BalanceEntity> balanceEntities=balanceRepository.findAllByStatus(1);
        if (!balanceEntities.isEmpty()) {
            List<BalanceDto> balanceDtos=new ArrayList<>();
            for(BalanceEntity balance:balanceEntities) {
//                balance.setBalance(balance.getBalance());
//                balance.setEffectiveBalance(balance.getEffectiveBalance());
//                balance.setLienBalance(balance.getLienBalance());
//                balance.setCurrency(balance.getCurrency());
//                balance.setAccountId(balance.getAccountId());
//                balance.setUserId(balance.getUserId());
//                BalanceEntity savedBalanced = balanceRepository.save(balance);
//                balanceDtos.add(savedBalanced);

                BalanceDto bd=modelMapper.map(balance, BalanceDto.class);
                balanceDtos.add(bd);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,balanceDtos,"Successfully Retrieved Balance");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No balance found");
    }

    @Override
    public Response getBalanceById(Long id) {
        BalanceEntity balance=balanceRepository.findByIdAndStatus(id,1);
        if(balance !=null){
            balance.setBalance(balance.getBalance());
            balance.setEffectiveBalance(balance.getEffectiveBalance());
            balance.setLienBalance(balance.getLienBalance());
            balance.setCurrency(balance.getCurrency());
            balance.setAccountId(balance.getAccountId());
            balance.setUserId(balance.getUserId());
            BalanceEntity savedBalanced=balanceRepository.save(balance);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,savedBalanced,"Successfully Retrieved Balance");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No balance found");
    }

    @Override
    public Response deleteBalanceById(Long id) {
        BalanceEntity balance=balanceRepository.findByIdAndStatus(id,1);
        if (balance != null) {
            balance.setStatus(0);
            balance.setBalance(balance.getBalance());
            balance.setEffectiveBalance(balance.getEffectiveBalance());
            balance.setLienBalance(balance.getLienBalance());
            balance.setCurrency(balance.getCurrency());
            balance.setAccountId(balance.getAccountId());
            balance.setUserId(balance.getUserId());
            BalanceEntity savedBalanced=balanceRepository.save(balance);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,savedBalanced,"Successfully Deleted Balance");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No balance found");
    }

    @Override
    public Response editBalanceById(Long id, BalanceDto balanceDto) {
        BalanceEntity balance=balanceRepository.findByIdAndStatus(id,1) ;
        if (balance != null) {
            balance.setStatus(1);
            balance.setBalance(balanceDto.getBalance());
            balance.setEffectiveBalance(balanceDto.getEffectiveBalance());
            balance.setLienBalance(balanceDto.getLienBalance());
            balance.setCurrency(balanceDto.getCurrency());
            balance.setAccountId(balanceDto.getAccountId());
            balance.setUserId(balanceDto.getUserId());
            BalanceEntity savedBalanced=balanceRepository.save(balance);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,savedBalanced,"Successfully Updated Balance");
        }

        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No balance found");
    }
}
