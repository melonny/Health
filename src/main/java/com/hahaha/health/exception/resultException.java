package com.hahaha.health.exception;

public class resultException {
    private int code;
    private String msg;
    private Long timestamp;

    public resultException(){}

    public resultException(exceptionEnum exceptionenum){
        this.code=exceptionenum.getCode();
        this.msg= exceptionenum.getMsg();
        this.timestamp=System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "resultException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
