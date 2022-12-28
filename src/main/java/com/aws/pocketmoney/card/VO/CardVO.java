package com.aws.pocketmoney.card.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "PAYMENT_HISTORY")
@Entity
public class CardVO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SN_SEQ")
    private Long snSeq;

    @Column(name = "APPROVAL_NUMBER")
    private String approvalNumber;

    @Column(name = "IDENTIFICATION")
    private String identification;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "CARD")
    private String card;

    @Column(name = "MERCHANT_NAME")
    private String merchantName;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "CLASSIFICATION")
    private String classification;

    @Column(name = "PURCHASE_STATUS")
    private String purchaseStatus;

    @Column(name = "SUBDIVISION_NUM")
    private Long subdivisionNum;

    @Column(name = "USEDATE")
    private String useDate;
}
