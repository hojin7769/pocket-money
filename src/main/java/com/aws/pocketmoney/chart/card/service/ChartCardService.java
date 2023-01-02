package com.aws.pocketmoney.chart.card.service;

import com.aws.pocketmoney.chart.card.VO.ChartCardVO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChartCardService {

    List<ChartCardVO> selectTotalPriceList(ChartCardVO vo);
    ChartCardVO selectTotalPriceAll (ChartCardVO vo);

    public List<ChartCardVO> selectMonthbyAmout(Integer month) ;

}
