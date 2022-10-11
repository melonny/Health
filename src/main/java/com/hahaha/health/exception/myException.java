package com.hahaha.health.exception;

public class myException extends RuntimeException{
    private exceptionEnum anEnum;

    public myException(exceptionEnum anEnum) {
        this.anEnum = anEnum;
    }

    public myException() {
    }

    public exceptionEnum getAnEnum() {
        return anEnum;
    }

    public void setAnEnum(exceptionEnum anEnum) {
        this.anEnum = anEnum;
    }

    @Override
    public String toString() {
        return "myException{" +
                "anEnum=" + anEnum +
                '}';
    }
}
