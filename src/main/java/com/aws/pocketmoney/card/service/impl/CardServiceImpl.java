package com.aws.pocketmoney.card.service.impl;

import com.aws.pocketmoney.card.VO.CardVO;
import com.aws.pocketmoney.card.brige.CardBrige;
import com.aws.pocketmoney.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardBrige cardBrige;

    @Override
    @Transactional
    public List<CardVO> saveAll(List<CardVO> list) {
        return cardBrige.saveAll(list);
    }

    @Override
    public CardVO saveOne(CardVO vo) {
        return cardBrige.saveOne(vo);
    }
}

