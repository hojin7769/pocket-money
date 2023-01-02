package com.aws.pocketmoney.controller;


import com.aws.pocketmoney.chart.card.VO.ChartCardVO;
import com.aws.pocketmoney.chart.card.service.ChartCardService;
import com.aws.pocketmoney.responses.BasicResponse;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chart/card")
public class ChartCardController {

    @Autowired
    ChartCardService chartCardService;


    @PostMapping("/selectAll")
    public ResponseEntity<?> selectCardTotalList(@RequestBody ChartCardVO vo){

        List<ChartCardVO> list = chartCardService.selectTotalPriceList(vo);
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(list).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }

    @PostMapping("/totalPrice")
    public ResponseEntity<?> selectTotalPriceAll (@RequestBody ChartCardVO vo){
        List<ChartCardVO> list = new ArrayList<ChartCardVO>();
        list.add(chartCardService.selectTotalPriceAll(vo));
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(list).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }

}
