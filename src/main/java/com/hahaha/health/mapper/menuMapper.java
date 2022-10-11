package com.hahaha.health.mapper;

import com.hahaha.health.entity.mainMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface menuMapper {
    public List<mainMenu> getMenus();
}
