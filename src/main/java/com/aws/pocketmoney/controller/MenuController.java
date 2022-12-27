package com.aws.pocketmoney.controller;

import com.aws.pocketmoney.menu.VO.MenuVO;
import com.aws.pocketmoney.menu.service.MenuService;
import com.aws.pocketmoney.responses.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {


    @Autowired
    MenuService menuService;


    @PostMapping("/list")
    public ResponseEntity<?> selectMenu(){
        List<MenuVO> list = menuService.selectMenu();
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(list).build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }




}