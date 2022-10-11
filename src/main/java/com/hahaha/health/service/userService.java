package com.hahaha.health.service;

import com.hahaha.health.entity.User;
import com.hahaha.health.mapper.userMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    userMapper usermapper;

    public User getUserByMessage(String username,String password){
        return usermapper.getUserByMessage(username,password);
    }

    public List<User> getAllUser(String username,int pageStart,int pageSize){
        return usermapper.getAllUser(username,pageStart,pageSize);
    }

    public int getUserCounts(String username){
        return usermapper.getUserCounts(username);
    }

    public int updateState(Integer id,boolean state){
        return usermapper.updateState(id,state);
    }

    public int addUser(User user){
        return usermapper.addUser(user);
    }

    public int editUser(User user){
        return usermapper.editUser(user);
    }

    public int deleteUser(Integer id){
        return usermapper.deleteUser(id);
    }
}
