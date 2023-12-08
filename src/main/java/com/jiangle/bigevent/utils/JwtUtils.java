package com.jiangle.bigevent.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    private static String KEY;
    private static long EXPIRATION_TIME;

    // 读取秘钥
    @Value("${jwt-utils.key}")
    public void setKey(String key) {
        JwtUtils.KEY = key;
    }

    // 读取过期时间
    @Value("#{${jwt-utils.expiration-time}}")
    public void setExpirationTime(long expirationTime) {
        JwtUtils.EXPIRATION_TIME = expirationTime;
    }


    // 通过jwt生成token
    public static String getToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(Date.from(Instant.now().plusMillis(EXPIRATION_TIME)))
                .sign(Algorithm.HMAC256(KEY));
    }

    // 解析jwt的token，返回业务数据
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

    public static long getExpirationTime() {
        return EXPIRATION_TIME;
    }
}
