package com.hahaha.health.controller;

import com.alibaba.fastjson.JSON;
import com.hahaha.health.dao.UserDao;
import com.hahaha.health.entity.QueryInfo;
import com.hahaha.health.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/userStateChange")
    public String updateUserState(@RequestParam("id")Integer id,
                                  @RequestParam("state")boolean state){
        int i = userDao.updateState(id,state);
        return i > 0?"success":"error";
    }

    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return i > 0 ?"success":"error";
    }
}
