package com.PaymentService.service;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.VisitsDto;

public interface VisitsService {
    Response createVisits(VisitsDto visitsDto);
    Response getVisitNoTransaction();
}
