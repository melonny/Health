package com.hahaha.health.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalException {
    @ExceptionHandler(myException.class)
    public ResponseEntity<resultException> handlerRuntimeexception(myException e){
        exceptionEnum exnum = e.getAnEnum();
        return ResponseEntity.status(exnum.getCode()).body(new resultException(exnum));
    }
}
