package com.aws.pocketmoney.card.service.impl;

import com.aws.pocketmoney.card.VO.CardVO;
import com.aws.pocketmoney.card.VO.QCardVO;
import com.aws.pocketmoney.card.brige.CardBrige;
import com.aws.pocketmoney.card.service.CardService;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardBrige cardBrige;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional
    public List<CardVO> saveAll(List<CardVO> list) {
        return cardBrige.saveAll(list);
    }

    @Override
    public CardVO saveOne(CardVO vo) {
        return cardBrige.saveOne(vo);
    }

    @Override
    public List<QCardVO> selectCount(CardVO vo) {
        QCardVO qCardVO = QCardVO.cardVO;


        return null;


    }
}

