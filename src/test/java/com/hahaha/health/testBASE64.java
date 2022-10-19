package com.hahaha.health;

import io.jsonwebtoken.impl.TextCodec;
import io.netty.handler.codec.base64.Base64Encoder;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
public class testBASE64 {
    public static void main(String args[]){
        String a = Base64.getEncoder().encodeToString("XULI".getBytes(StandardCharsets.UTF_8));
        byte[] b = TextCodec.BASE64.decode(a);
        System.out.println(a);
        System.out.println(b);
    }
}
