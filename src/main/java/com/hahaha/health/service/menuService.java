package com.hahaha.health.service;

import com.hahaha.health.entity.mainMenu;
import com.hahaha.health.mapper.menuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class menuService {
    @Autowired
    menuMapper menumapper;

    public List<mainMenu> getMenus(){
        return menumapper.getMenus();
    }
}
