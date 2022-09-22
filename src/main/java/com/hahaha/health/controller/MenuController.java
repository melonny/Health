package com.hahaha.health.controller;

import com.alibaba.fastjson.JSON;
import com.hahaha.health.dao.MenuDAO;
import com.hahaha.health.entity.mainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuDAO menuDAO;

    @RequestMapping("/menus")
    public String getAllMenus(){
        System.out.println("访问成功~");
        HashMap<String, Object> data = new HashMap<>();
        List<mainMenu> menus = menuDAO.getMenus();
        if(menus!=null){
            data.put("menus",menus);
            data.put("flag",200);
        }else{
            data.put("flag",404);
        }
        String s = JSON.toJSONString(data);
        return s;
    }
}
