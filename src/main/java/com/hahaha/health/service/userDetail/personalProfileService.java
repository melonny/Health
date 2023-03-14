package com.hahaha.health.service.userDetail;

import com.hahaha.health.entity.userDetail.personalProfile;
import com.hahaha.health.mapper.userDetail.personalProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class personalProfileService{
    @Autowired
    personalProfileMapper profileMapper;

    public int addProfile(personalProfile p) {
        return profileMapper.addProfile(p);
    }

    public int changeProfile(personalProfile p) {
        return profileMapper.changeProfile(p);
    }

    public personalProfile selectProfileById(int id) {
        return profileMapper.selectProfileById(id);
    }
}
