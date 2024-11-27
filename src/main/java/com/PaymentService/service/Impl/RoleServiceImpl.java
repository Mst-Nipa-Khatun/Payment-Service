package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleDto;
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
    public Response createRole(RoleDto roleDto) {
        UsersEntity usersEntity=usersRepository.findByIdAndStatus(roleDto.getUserId(),1);
        if(usersEntity==null){
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                    "UserId not found");
        }
        RoleEntity roleEntity =roleRepository.findByNameAndStatus(roleDto.getName(),1);
        if(roleEntity ==null){
            roleEntity =modelMapper.map(roleDto, RoleEntity.class);
            roleEntity.setStatus(1);
            RoleEntity savedRoleEntity =roleRepository.save(roleEntity);

            usersEntity.setRoleEntityList(Collections.singletonList(savedRoleEntity));
            usersRepository.save(usersEntity);
            RoleDto savedRoleDto =modelMapper.map(savedRoleEntity, RoleDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, savedRoleDto,
                    "Successfully created role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Role already exists");
    }

    @Override
    public Response getAllRoleByUserId(Long userId) {
        List<RoleEntity> roleEntityList =roleRepository.findAllByStatus(1);
        if(!roleEntityList.isEmpty()){
            List<RoleDto> roleDtos =new ArrayList<>();
            for(RoleEntity roleEntity : roleEntityList){
                RoleDto roleDto =modelMapper.map(roleEntity, RoleDto.class);
                roleDtos.add(roleDto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, roleDtos,
                    "Successfully retrieved roles");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "No roles found");
    }
}
