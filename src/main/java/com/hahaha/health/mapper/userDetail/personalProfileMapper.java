package com.hahaha.health.mapper.userDetail;

import com.hahaha.health.entity.userDetail.personalProfile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface personalProfileMapper {
    public int addProfile(personalProfile p);
    public int changeProfile(personalProfile p);
    public personalProfile selectProfileById(int id);
}
