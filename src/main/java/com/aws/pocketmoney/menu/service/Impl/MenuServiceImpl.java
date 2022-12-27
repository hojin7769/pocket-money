package com.aws.pocketmoney.menu.service.Impl;

import com.aws.pocketmoney.menu.VO.MenuVO;
import com.aws.pocketmoney.menu.bridge.MenuBridge;
import com.aws.pocketmoney.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuBridge menuBridge;

    @Override
    public List<MenuVO> selectMenu() {
        return menuBridge.selectMenu();
    }
}
