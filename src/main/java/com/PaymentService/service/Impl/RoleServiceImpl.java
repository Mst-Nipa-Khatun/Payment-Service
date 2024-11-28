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
        //ekta role create korar jonno first e userId onujay value  ase kina check kora dorkar,tai jonno user entity userRepo db
        //anlam thn roledto te userId ase kina ei jonno if conditions.thn na thakle to fail otherwise second function

        if(usersEntity==null){
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                    "UserId not found");
        }
        RoleEntity roleEntity =roleRepository.findByNameAndStatus(roleDto.getName(),1);
        if(roleEntity ==null){
            roleEntity =modelMapper.map(roleDto, RoleEntity.class); //roleDto k convert kore nilam
            roleEntity.setStatus(1);
            RoleEntity savedRoleEntity =roleRepository.save(roleEntity);


            List<RoleEntity> existingRoleList = usersEntity.getRoleEntityList();
            existingRoleList.add(savedRoleEntity);
            usersEntity.setRoleEntityList(existingRoleList);

            usersRepository.save(usersEntity);
            RoleDto savedRoleDto =modelMapper.map(savedRoleEntity, RoleDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, savedRoleDto,
                    "Successfully created role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Role already exists");
    }

    @Override
    public Response getAllRoleByUserId(Long userId) {
        List<RoleEntity> roleEntityList =roleRepository.findAllByUserIdAndStatus(userId,1);
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

    @Override
    public Response getRoleById(Long id) {
        RoleEntity roleEntity = roleRepository.findByIdAndStatus(id,1);
        if(roleEntity!=null){
            RoleDto roleDto =modelMapper.map(roleEntity, RoleDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,roleDto,
                    "Successfully retrieved role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "No role found");
    }

    @Override
    public Response deleteRoleById(Long id) {
        RoleEntity roleEntity = roleRepository.findByIdAndStatus(id,1);
        if(roleEntity!=null){
            roleEntity.setStatus(0);
            RoleEntity saveRole=roleRepository.save(roleEntity);
            RoleDto roleDto =modelMapper.map(saveRole, RoleDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,roleDto,"Successfully deleted role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No role found");
    }

    @Override
    public Response editRoleById(Long id, RoleDto roleDto) {
        RoleEntity roleEntity = roleRepository.findByIdAndStatus(id,1);
        if(roleEntity!=null){
            RoleEntity roleEntity1 =modelMapper.map(roleDto, RoleEntity.class);
            roleEntity.setStatus(1);
            RoleEntity saveRoleEntity =roleRepository.save(roleEntity1);
            RoleDto savedRoleDto =modelMapper.map(saveRoleEntity, RoleDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,savedRoleDto,"Successfully updated role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,"No role found");
    }
}
