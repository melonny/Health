package com.hahaha.health.exception;

public enum exceptionEnum {
    NOT_NULL(400,"字段不能为空");

    private int code;
    private String msg;

    exceptionEnum(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }
    exceptionEnum(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
