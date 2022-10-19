package com.hahaha.health.mapper;

import com.hahaha.health.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userMapper {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart,
                                 @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int updateState(@Param("id")Integer id, @Param("state") boolean state);
    public int addUser(User user);
    public int editUser(User user);
    public int deleteUser(@Param("id")Integer id);
    public User selectUserById(@Param("id")Integer id);
}
