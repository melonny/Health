package com.hahaha.health.controller.userDetail;

import com.alibaba.fastjson.JSON;
import com.hahaha.health.service.userDetail.personalProfileService;
import com.hahaha.health.entity.userDetail.personalProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userDetail")
public class personalProfileController {
    @Autowired
    personalProfileService profileService;

    @GetMapping("/personalProfile")
    public String getPersonalProfile(int id){
        personalProfile p = profileService.selectProfileById(id);
        if(p == null){
            return "null";
        }
        Map<String, String> m = new HashMap<>();
        m.put("sex", p.getSex());
        m.put("age", p.getAge());
        m.put("height", p.getHeight().toString());
        m.put("weight", p.getWeight().toString());
        return JSON.toJSONString(m);
    }

    @PostMapping("/personalProfile")
    public String addPersonalProfile(personalProfile p){
        int i = profileService.addProfile(p);
        return i>0?"success":"error";
    }

    @PutMapping("/personalProfile")
    public String changePersonalProfile(personalProfile p){
        int i = profileService.changeProfile(p);
        return i>0?"success":"error";
    }
}
