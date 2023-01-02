package com.aws.pocketmoney.chart.card.VO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChartCardVO {
    private int totalPrice;
    private String shopName;
    private String useDate;
    private String beforeDate;
    private String afterDate;


}
