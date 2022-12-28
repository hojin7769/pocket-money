package com.aws.pocketmoney.card.service;

import com.aws.pocketmoney.card.VO.CardVO;

import java.util.List;

public interface CardService {

    List<CardVO> saveAll(List<CardVO> list);
    CardVO saveOne(CardVO vo);
}
