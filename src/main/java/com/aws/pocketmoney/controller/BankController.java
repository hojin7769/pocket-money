package com.aws.pocketmoney.controller;

import com.aws.pocketmoney.bank.VO.BankVO;
import com.aws.pocketmoney.bank.service.BankService;
import com.aws.pocketmoney.responses.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    BankService bankService;


    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<BankVO> list){
        List<BankVO> resultList = bankService.saveAll(list);
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(resultList).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());

    }

}
