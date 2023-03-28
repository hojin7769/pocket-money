package com.aws.pocketmoney.chart.card.brige;

import com.aws.pocketmoney.card.brige.CardBrige;
import com.aws.pocketmoney.card.repository.CareRepository;
import com.aws.pocketmoney.chart.card.VO.ChartCardVO;
import com.aws.pocketmoney.common.annotation.Bridge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Bridge
public class ChartCardBrige {

    @Autowired
    CareRepository careRepository;



    @Bridge
    public ChartCardVO selectTotalPriceAll(ChartCardVO vo){
        return null;
    }


    @Bridge
    public List<ChartCardVO> selectChartCard(ChartCardVO vo) {
      return null;
    }

    @Bridge
    public List<ChartCardVO> selectMonthbyAmout(Integer month) {

        System.out.println(careRepository.findAll(month));


        return null;
    }







}
