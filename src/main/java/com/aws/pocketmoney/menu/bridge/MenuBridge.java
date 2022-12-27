package com.aws.pocketmoney.menu.bridge;

import com.aws.pocketmoney.common.annotation.Bridge;
import com.aws.pocketmoney.menu.VO.MenuVO;
import com.aws.pocketmoney.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Bridge
public class MenuBridge {

    @Autowired
    MenuRepository menuRepository;

    @Bridge
    public List<MenuVO> selectMenu(){
        return menuRepository.findAll();
    }
}
