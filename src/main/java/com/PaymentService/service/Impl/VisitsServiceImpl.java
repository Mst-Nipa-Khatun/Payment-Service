package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.VisitsDto;
import com.PaymentService.repository.VisitsRepository;
import com.PaymentService.service.VisitsService;
import org.springframework.stereotype.Service;

@Service
public class VisitsServiceImpl implements VisitsService {
    private final VisitsRepository visitsRepository;


    public VisitsServiceImpl(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @Override
    public Response createVisits(VisitsDto visitsDto) {
        return null;
    }
}
