package com.hahaha.health.entity;

import java.util.List;

public class mainMenu {
    private int id;
    private String title;
    private String path;
    private List<subMenu> subMenuList;

    public mainMenu() {
    }

    public mainMenu(String title, String path, List<subMenu> subMenuList) {
        this.title = title;
        this.path = path;
        this.subMenuList = subMenuList;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public List<subMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSubMenuList(List<subMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    @Override
    public String toString() {
        return "mainMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", subMenuList=" + subMenuList +
                '}';
    }
}
