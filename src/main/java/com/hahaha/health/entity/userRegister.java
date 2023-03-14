package com.hahaha.health.entity;

public class userRegister {
    private User user;
    private String code;

    public userRegister() {
    }

    public userRegister(User user, String code) {
        this.user = user;
        this.code = code;
    }

    @Override
    public String toString() {
        return "userRegister{" +
                "user=" + user +
                ", code='" + code + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
