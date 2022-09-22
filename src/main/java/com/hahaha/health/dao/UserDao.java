package com.hahaha.health.dao;

import com.hahaha.health.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart,
                                 @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int updateState(@Param("id")Integer id, @Param("state") boolean state);
    public int addUser(User user);
}
