package com.aws.pocketmoney.card.brige;

import com.aws.pocketmoney.card.VO.CardVO;
import com.aws.pocketmoney.card.repository.CareRepository;
import com.aws.pocketmoney.common.annotation.Bridge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Bridge
public class CardBrige {


    @Autowired
    CareRepository careRepository;

    @Bridge
    public List<CardVO> saveAll(List<CardVO> list){

        if(list.isEmpty()) {
            throw new RuntimeException("데이터가 존재하지 않습니다");
        }else{
          return  careRepository.saveAll(list);
        }
    }

    @Bridge
    public CardVO saveOne(CardVO vo){
        if(vo == null){
            throw new RuntimeException("데이터가 없습니다.");
        }else{
            return careRepository.save(vo);
        }
    }
}
