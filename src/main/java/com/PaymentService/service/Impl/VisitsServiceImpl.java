package com.PaymentService.service.Impl;

import com.PaymentService.dto.Response;
import com.PaymentService.dto.VisitsDetailsProjection;
import com.PaymentService.dto.VisitsDto;
import com.PaymentService.entity.TransactionsForVisitsEntity;
import com.PaymentService.entity.VisitsEntity;
import com.PaymentService.repository.TransactionForVisitRepository;
import com.PaymentService.repository.VisitsRepository;
import com.PaymentService.service.VisitsService;
import com.PaymentService.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitsServiceImpl implements VisitsService {
    private final VisitsRepository visitsRepository;
    private final TransactionForVisitRepository transactionForVisitRepository;


    public VisitsServiceImpl(VisitsRepository visitsRepository, TransactionForVisitRepository transactionForVisitRepository) {
        this.visitsRepository = visitsRepository;
        this.transactionForVisitRepository = transactionForVisitRepository;
    }

    @Override
    public Response createVisits(VisitsDto visitsDto) {
        VisitsEntity visits=visitsRepository.findByVisitId(visitsDto.getVisitId());
        if(visits==null) {
            visits=new VisitsEntity();
            visits.setVisitId(visitsDto.getVisitId());
            visits.setCustomerId(visitsDto.getCustomerId());
           VisitsEntity savedVisits= visitsRepository.save(visits);
           return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,savedVisits,
                   "successfully created");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "Already exists");
    }

    @Override
    public Response getVisitNoTransaction() {
        List<VisitsDetailsProjection> visits=visitsRepository.findByVisitsAndNoTransaction();
        if(!visits.isEmpty()) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,visits,
                    "successfully retrieved");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,null,
                "No transaction found");
    }

    @Override
    public Response getVisitsNoTransactionJPA() {
        List<TransactionsForVisitsEntity> transactions=transactionForVisitRepository.findAll();
        /*Bashai giye dekhassi... transactions er moddhe full visit table er data ase tai na...
        * tahole ekhnon ei table er visit id transactions table e jegula nai segula ante hobe age...
        *
        * 1-Amar visit table theke visit r coustomrid duitai lagbe tai findall kore sob find korbo.
        * 2-Same vabe transaction table ew transaction id o visit id kisu kisu jar sathe ami visit table e
        * visitid r sathe check kora lagbe ei jonnow ami transactio table findall korbo,
        * 3-Akhon transaction id jodi not empty hoy tahole t theke visitid ,visit table visit id j gulo nai check korbo,
        * 4-visit id count er jonno kaj korbo
        * 5-save korbo repo te.
        *

        * ki ki korte hobe line by line 1,2,3 diye agge ikho then code start koro.... :) :):( bye
        *  */
        //List<TransactionsForVisitsEntity> transactions1=transactionForVisitRepository.findAllBy();
        if(!transactions.isEmpty()) {

            return ResponseBuilder.getSuccessResponse(HttpStatus.OK,transactions,
                    "successfully retrieved");
        }
        //List<VisitsEntity> visitsEntities=visitsRepository.findByCustomerId();
        return null;
    }
}
