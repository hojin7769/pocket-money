package com.aws.pocketmoney.bank.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "PAYMENT_BANK_HISTORY")
@Entity
public class BankVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SN_SEQ;
    //일자 + 시간
    @Column(name = "DT_TRANSACTION")
    private String dtTransaction;
    //적용
    @Column(name ="BRIEFS" )
    private String briefs;
    //출금
    @Column(name ="WITHDRAWAL")
    private int withdrawal;
    //입금
    @Column(name ="DEPOSIT")
    private int deposit;
    //내용
    @Column(name ="CONTENTS")
    private String contents;
    //잔액
    @Column(name ="BALANCE")
    private int balance;
    //거래처
    @Column(name ="TRADING_POINT")
    private String tradingPoint;

}
