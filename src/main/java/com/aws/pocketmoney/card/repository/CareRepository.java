package com.aws.pocketmoney.card.repository;

import com.aws.pocketmoney.card.VO.CardVO;
import com.aws.pocketmoney.chart.card.VO.ChartCardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareRepository extends JpaRepository<CardVO,Long> {

    @Query(value = "SELECT SUM(amount) as totalPrice,MONTH (useDate) as useDate FROM CardVO GROUP BY MONTH (useDate)")
    List<ChartCardVO> findAll(Integer month);
}
