package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleEntityDto;
import com.PaymentService.entity.RoleEntity;
import com.PaymentService.entity.UsersEntity;
import com.PaymentService.repository.RoleRepository;
import com.PaymentService.repository.UsersRepository;
import com.PaymentService.service.RoleService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper, com.PaymentService.repository.UsersRepository usersRepository) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }

    @Override
    public Response createRole(RoleEntityDto roleEntityDto) {
        UsersEntity usersEntity=usersRepository.findByIdAndStatus(roleEntityDto.getUserId(),1);
        if(usersEntity==null){
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                    "UserId not found");
        }
        RoleEntity roleEntity =roleRepository.findByNameAndStatus(roleEntityDto.getName(),1);
        if(roleEntity ==null){
            roleEntity =modelMapper.map(roleEntityDto, RoleEntity.class);
            roleEntity.setStatus(1);
            RoleEntity savedRoleEntity =roleRepository.save(roleEntity);

            usersEntity.setRoleEntityList(Collections.singletonList(savedRoleEntity));
            usersRepository.save(usersEntity);
            RoleEntityDto savedRoleEntityDto =modelMapper.map(savedRoleEntity, RoleEntityDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, savedRoleEntityDto,
                    "Successfully created role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Role already exists");
    }

    @Override
    public Response getAllRoleByUserId(Long userId) {
        List<RoleEntity> roleEntityList =roleRepository.findAllByStatus(1);
        if(!roleEntityList.isEmpty()){
            List<RoleEntityDto> roleEntityDtos =new ArrayList<>();
            for(RoleEntity roleEntity : roleEntityList){
                RoleEntityDto roleEntityDto =modelMapper.map(roleEntity, RoleEntityDto.class);
                roleEntityDtos.add(roleEntityDto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, roleEntityDtos,
                    "Successfully retrieved roles");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "No roles found");
    }
}
