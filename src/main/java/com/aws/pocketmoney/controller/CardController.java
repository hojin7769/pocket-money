package com.aws.pocketmoney.controller;

import com.aws.pocketmoney.card.VO.CardVO;
import com.aws.pocketmoney.card.service.CardService;
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
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<CardVO> list){
        List<CardVO> resultList = cardService.saveAll(list);
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(resultList).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());

    }

}
