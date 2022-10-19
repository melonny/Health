package com.hahaha.health.controller;

import com.alibaba.fastjson.JSON;
import com.hahaha.health.entity.User;
import com.hahaha.health.entity.mainMenu;
import com.hahaha.health.service.menuService;
import com.hahaha.health.service.userService;
import com.hahaha.health.util.tokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    menuService menuservice;
    @Autowired
    tokenUtil tokenutil;
    @Autowired
    userService userservice;

    @RequestMapping("/menus")
    public String getAllMenus(@RequestHeader("Authorization") String token){
        System.out.println("访问成功~");
        HashMap<String, Object> data = new HashMap<>();
        User tokenuser = tokenutil.jwtParser(token);
        User user = null;
        if(tokenuser != null) user = userservice.selectUserById(tokenuser.getId());
        if(user == null){
            data.put("flag",404);
            return JSON.toJSONString(data);
        }else{
            List<mainMenu> menus = menuservice.getMenus();
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
}
