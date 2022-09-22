package com.hahaha.health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HealthApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("测试displayname注解")
    void testDisplayName(){

    }

    @BeforeEach
    @Test
    void testBeforeEach(){
        System.out.println("测试开始啦");

    }

    @AfterEach
    @Test
    void testAfterEach(){
        System.out.println("测试结束啦");
    }

}
