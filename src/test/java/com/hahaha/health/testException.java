package com.hahaha.health;

import com.hahaha.health.exception.exceptionEnum;
import com.hahaha.health.exception.myException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testException {
    @Test
    void testexception(){
        try{
            throw new myException(exceptionEnum.NOT_NULL);
        }catch (myException e){
            System.out.println(e);
        }
    }
}
