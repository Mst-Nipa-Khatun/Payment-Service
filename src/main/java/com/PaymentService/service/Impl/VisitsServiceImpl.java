package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.VisitsDto;
import com.PaymentService.entity.VisitsEntity;
import com.PaymentService.repository.VisitsRepository;
import com.PaymentService.service.VisitsService;
import com.PaymentService.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class VisitsServiceImpl implements VisitsService {
    private final VisitsRepository visitsRepository;


    public VisitsServiceImpl(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @Override
    public Response createVisits(VisitsDto visitsDto) {
        VisitsEntity visits=visitsRepository.findByVisitId(visitsDto.getVisitId());
        if(visits==null) {
            visits=new VisitsEntity();
            visits.setVisitId(visitsDto.getVisitId());
            visits.setCustomerId(visitsDto.getCustomerId());
           VisitsEntity savedVisits= visitsRepository.save(visits);
           return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,savedVisits,"successfully created");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,"Already exists");
    }
}
