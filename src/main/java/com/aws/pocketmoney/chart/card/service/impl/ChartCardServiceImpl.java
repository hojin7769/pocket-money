package com.aws.pocketmoney.chart.card.service.impl;

import com.aws.pocketmoney.card.brige.CardBrige;
import com.aws.pocketmoney.chart.card.VO.ChartCardVO;
import com.aws.pocketmoney.chart.card.brige.ChartCardBrige;
import com.aws.pocketmoney.chart.card.service.ChartCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartCardServiceImpl implements ChartCardService {

    @Autowired
    ChartCardBrige chartCardBrige;

    @Autowired
    CardBrige cardBrige;

    @Override
    public List<ChartCardVO> selectTotalPriceList(ChartCardVO vo) {
        return chartCardBrige.selectChartCard(vo);
    }

    @Override
    public ChartCardVO selectTotalPriceAll(ChartCardVO vo) {
        return chartCardBrige.selectTotalPriceAll(vo);
    }

    @Override
    public List<ChartCardVO> selectMonthbyAmout(Integer month) {

        return null;
    }
}
