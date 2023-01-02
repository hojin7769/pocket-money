package com.aws.pocketmoney.bank.brige;

import com.aws.pocketmoney.bank.VO.BankVO;
import com.aws.pocketmoney.bank.repository.BankRepository;
import com.aws.pocketmoney.card.VO.CardVO;
import com.aws.pocketmoney.common.annotation.Bridge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Bridge
public class BankBrige {

    @Autowired
    BankRepository bankRepository;

    @Bridge
    public List<BankVO> saveAll (List<BankVO> list){
        if(list.isEmpty()){
            throw new RuntimeException("데이터 없음");
        }
       return bankRepository.saveAll(list);
    }


    @Bridge
    public BankVO saveOne(BankVO vo){
        if(vo == null){
            throw new RuntimeException("데이터가 없습니다.");
        }else{
            return bankRepository.save(vo);
        }
    }


}
