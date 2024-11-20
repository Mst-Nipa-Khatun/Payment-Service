package com.PaymentService.service.Impl;

import com.PaymentService.dto.PrivilegeDto;
import com.PaymentService.dto.Response;
import com.PaymentService.repository.PrivilegeRepository;
import com.PaymentService.service.PrivilegeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository privilegeRepository;
    private final ModelMapper modelMapper;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository, ModelMapper modelMapper) {
        this.privilegeRepository = privilegeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createPrivilege(PrivilegeDto privilegeDto) {
        return null;
    }
}
