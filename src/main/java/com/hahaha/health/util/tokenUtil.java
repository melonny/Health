package com.hahaha.health.util;

import com.hahaha.health.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class tokenUtil {
    // token时间
    @Value("${spring.jwt.ttl}")
    private long time;
    @Value("${spring.jwt.signature}")
    private String signature;
    public  String createToken(String userName,Integer id){
        JwtBuilder jwtBuilder= Jwts.builder();
        String jwtToken=jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("userId",id.toString())
                .claim("userName",userName)
                .setSubject("WEBTOKEN")
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,  Base64.getEncoder().encodeToString(signature.getBytes(StandardCharsets.UTF_8)))
                .compact();
        return jwtToken;
    }

    // 解析token
    public User jwtParser(String token) {
        Claims claims = null;
        User user= new User();
        if(token ==null||token.length()==0) return null;
        // token不一定通过验证，所以需要包裹try-catch捕获jjwt提供的JwtException
        try {
            claims = Jwts.parser()
                    // HS256是对称加密体系，加密解密使用同一个key
                    .setSigningKey(Base64.getEncoder().encodeToString(signature.getBytes(StandardCharsets.UTF_8)))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {

            throw new RuntimeException("JWT过期");
        } catch (UnsupportedJwtException e) {

            throw new RuntimeException("不支持的JWT");
        } catch (MalformedJwtException e) {

            throw new RuntimeException("JWT格式错误");
        } catch (SignatureException e) {

            throw new RuntimeException("签名异常");
        } catch (IllegalArgumentException e) {

            throw new RuntimeException("非法请求");
        } catch (Exception e) {

            throw new RuntimeException("解析异常");
        }
        finally {
            if(claims!=null) {
                int userId = Integer.parseInt((String) claims.get("userId"));
                String userName = (String) claims.get("userName");
                user.setId(userId);
                user.setUsername(userName);
            }
            else{
                return null;
            }
            return user;
        }


    }
}
