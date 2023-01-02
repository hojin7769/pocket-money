package com.aws.pocketmoney.chart.card.brige;

import com.aws.pocketmoney.card.VO.QCardVO;
import com.aws.pocketmoney.card.brige.CardBrige;
import com.aws.pocketmoney.card.repository.CareRepository;
import com.aws.pocketmoney.chart.card.VO.ChartCardVO;
import com.aws.pocketmoney.common.annotation.Bridge;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Bridge
public class ChartCardBrige {
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    CareRepository careRepository;



    @Bridge
    public ChartCardVO selectTotalPriceAll(ChartCardVO vo){
        QCardVO qCardVO = QCardVO.cardVO;
        ChartCardVO result = new ChartCardVO();

       Integer tt =  jpaQueryFactory.select(qCardVO.amount.sum())
                .from(qCardVO)
                .where(qCardVO.useDate.between(vo.getBeforeDate(), vo.getAfterDate()))
                .fetchOne();
       result.setTotalPrice(tt);
        return result;
    }


    @Bridge
    public List<ChartCardVO> selectChartCard(ChartCardVO vo) {
        QCardVO cardVO = QCardVO.cardVO;
        List<ChartCardVO> list = new ArrayList<>();
        jpaQueryFactory.select(cardVO.merchantName, cardVO.amount.sum())
                .from(cardVO)
                .where(cardVO.useDate.between(vo.getBeforeDate(), vo.getAfterDate()))
                .groupBy(cardVO.merchantName)
                .fetch()
                .forEach(data -> {
                    ChartCardVO resultVO = new ChartCardVO();
                    int price = 0;
                    String name = "";
                    try {
                        price = data.get(cardVO.amount.sum());
                        name = data.get(cardVO.merchantName);
                    } catch (NullPointerException e) {
                        price = 0;
                        name = "";
                    }
                    resultVO.setTotalPrice(price);
                    resultVO.setShopName(name);
                    list.add(resultVO);
                });

        return list;
    }

    @Bridge
    public List<ChartCardVO> selectMonthbyAmout(Integer month) {

        System.out.println(careRepository.findAll(month));


        return null;
    }







}
