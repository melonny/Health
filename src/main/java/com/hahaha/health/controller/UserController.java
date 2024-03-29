package com.hahaha.health.controller;

import com.alibaba.fastjson.JSON;
import com.hahaha.health.entity.QueryInfo;
import com.hahaha.health.entity.User;
import com.hahaha.health.entity.mainMenu;
import com.hahaha.health.entity.userRegister;
import com.hahaha.health.service.userService;
import com.hahaha.health.util.redisUtil;
import com.hahaha.health.util.tokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    userService userservice;
    @Autowired
    redisUtil redis;
    @Autowired
    tokenUtil tokenutil;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        int numbers = userservice.getUserCounts("%"+queryInfo.getQuery()+"%");
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = userservice.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/userStateChange")
    public String updateUserState(@RequestParam("id")Integer id,
                                  @RequestParam("state")boolean state){
        int i = userservice.updateState(id,state);
        return i > 0?"success":"error";
    }

    @RequestMapping("/adduser")
    public String addUser(@RequestBody userRegister userregister){
        User user = userregister.getUser();
        if(userservice.getUserByMessage(user.getUsername(), user.getPassword())!=null){
            return "exit";
        }
        String validCode = userregister.getCode();
        String redisCode = redis.get(user.getEmail());
        if(!redisCode.equals(validCode)){
            return "codeError";
        }
        user.setRole("普通用户");
        user.setState(false);
        int i = userservice.addUser(user);
        return i > 0 ?"success":"error";
    }

    @PutMapping("/edituser")
    public String editUser(@RequestBody User user){
        int i = userservice.editUser(user);
        return i > 0 ?"success":"error";
    }

    @DeleteMapping("deleteuser")
    public String deleteUser(@RequestParam Integer id){
        int i = userservice.deleteUser(id);
        return i > 0 ?"success":"error";
    }

    @PostMapping("/eat")
    public String eatFood(@RequestHeader("Authorization")String token,
                          @RequestParam("foodId")Integer foodId,
                          @RequestParam("timeStamp")Timestamp timestamp){
        User tokenuser = tokenutil.jwtParser(token);
        User user = null;
        if(tokenuser != null) user = userservice.selectUserById(tokenuser.getId());
        if(user == null){
            return "eatFail";
        }else{
            return userservice.eatFood(user.getId(), foodId, timestamp)>0?"eatSuccess":"eatFail";
        }
    }
}
