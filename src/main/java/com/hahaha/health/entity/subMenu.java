package com.hahaha.health.entity;

public class subMenu {
    private int id;
    private String title;
    private String path;

    public subMenu() {
    }

    public subMenu(String title, String path) {
        this.title = title;
        this.path = path;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "subMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
