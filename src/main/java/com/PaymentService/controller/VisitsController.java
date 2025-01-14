package com.PaymentService.controller;


import com.PaymentService.dto.Response;
import com.PaymentService.dto.VisitsDto;
import com.PaymentService.service.VisitsService;
import com.PaymentService.utils.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstraint.Visits.ROOT)
public class VisitsController {
    private final VisitsService visitsService;

    public VisitsController(VisitsService visitsService) {
        this.visitsService = visitsService;
    }
    @PostMapping(UrlConstraint.Visits.CREATE)
    public Response createVisits(@RequestBody VisitsDto visitsDto) {
        return visitsService.createVisits(visitsDto);
    }
    @GetMapping(UrlConstraint.Visits.GET_VISIT_NO_TRANSACTION)
    public Response getVisitsNoTransaction() {
        return visitsService.getVisitNoTransaction();
    }
}
