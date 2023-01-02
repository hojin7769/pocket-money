package com.aws.pocketmoney.bank.service;

import com.aws.pocketmoney.bank.VO.BankVO;

import java.util.List;

public interface BankService {

    List<BankVO> saveAll(List<BankVO> list);
    BankVO saveOne(BankVO vo);

}
