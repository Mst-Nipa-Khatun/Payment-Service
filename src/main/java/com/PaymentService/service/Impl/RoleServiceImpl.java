package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.RoleDto;
import com.PaymentService.entity.Role;
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
        Role role=roleRepository.findByNameAndStatus(roleDto.getName(),1);
        if(role==null){
            role=modelMapper.map(roleDto,Role.class);
            role.setStatus(1);
            Role savedRole=roleRepository.save(role);

            usersEntity.setRoleList(Collections.singletonList(savedRole));
            usersRepository.save(usersEntity);
            RoleDto savedRoleDto=modelMapper.map(savedRole,RoleDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,savedRoleDto,
                    "Successfully created role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Role already exists");
    }

    @Override
    public Response getAllRoleByUserId(Long userId) {
        List<Role> roleList=roleRepository.findAllByStatus(1);
        if(!roleList.isEmpty()){
            List<RoleDto> roleDtos=new ArrayList<>();
            for(Role role:roleList){
                RoleDto roleDto=modelMapper.map(role,RoleDto.class);
                roleDtos.add(roleDto);
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,roleDtos,
                    "Successfully retrieved roles");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT,null,
                "No roles found");
    }
}
