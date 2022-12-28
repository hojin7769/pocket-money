package com.aws.pocketmoney.card.repository;

import com.aws.pocketmoney.card.VO.CardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareRepository extends JpaRepository<CardVO,Long> {
}
