package com.aws.pocketmoney.menu.repository;

import com.aws.pocketmoney.menu.VO.MenuVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

public interface MenuRepository extends JpaRepository<MenuVO, Long> {


}

