package com.aws.pocketmoney.chart.card.VO;

public class ChartCardBuilder {

    private int totalPrice;
    private String shopName;
    private String useDate;
    private String beforeDate;
    private String afterDate;

    public ChartCardVO build(){
        ChartCardVO cardVO = new ChartCardVO();
        cardVO.setTotalPrice(this.totalPrice);
        cardVO.setShopName(this.shopName);
        cardVO.setAfterDate(this.afterDate);
        cardVO.setBeforeDate(this.beforeDate);
        cardVO.setUseDate(this.useDate);

        return cardVO;
    }

    public ChartCardBuilder totalPrice(int totalPrice){
        this.totalPrice = totalPrice;
        return this;
    }

    public ChartCardBuilder shopName(String shopName){
        this.shopName = shopName;
        return this;
    }

    public ChartCardBuilder useDate(String useDate){
        this.useDate = useDate;
        return this;
    }

    public ChartCardBuilder afterDate(String afterDate){
        this.afterDate = afterDate;
        return this;
    }

    public ChartCardBuilder beforeDate (String beforeDate){
        this.beforeDate = beforeDate;
        return this;
    }

}
