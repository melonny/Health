package com.hahaha.health.controller;

import com.hahaha.health.util.emailUtil;
import com.hahaha.health.util.redisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class emailController {
    @Autowired
    redisUtil redis;
    @Autowired
    private emailUtil se;
    @RequestMapping("/code")
    public String sendCode(@RequestParam("email")String email){
        System.out.println(email);
        String code = se.sendEmail(email);
        redis.set(email,code);
        System.out.println(redis.get(email));
        System.out.println(email+":"+code);
        return "Success";
    }
}
