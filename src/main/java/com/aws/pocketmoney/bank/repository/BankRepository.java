package com.aws.pocketmoney.bank.repository;

import com.aws.pocketmoney.bank.VO.BankVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankVO,Long> {
}
