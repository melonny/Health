package com.hahaha.health.dao;

import com.hahaha.health.entity.mainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDAO {
    public List<mainMenu> getMenus();
}
