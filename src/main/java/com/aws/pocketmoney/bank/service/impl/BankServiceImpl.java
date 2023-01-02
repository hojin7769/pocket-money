package com.aws.pocketmoney.bank.service.impl;

import com.aws.pocketmoney.bank.VO.BankVO;
import com.aws.pocketmoney.bank.brige.BankBrige;
import com.aws.pocketmoney.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankBrige bankBrige;

    @Override
    public List<BankVO> saveAll(List<BankVO> list) {
        return bankBrige.saveAll(list);
    }

    @Override
    public BankVO saveOne(BankVO vo) {
        return bankBrige.saveOne(vo);
    }
}
