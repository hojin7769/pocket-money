package com.aws.pocketmoney.menu.service;

import com.aws.pocketmoney.menu.VO.MenuVO;

import java.util.List;

public interface MenuService {

     List<MenuVO> selectMenu();
    MenuVO addMenu(MenuVO vo);
}
