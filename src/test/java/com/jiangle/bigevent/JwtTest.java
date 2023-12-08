package com.jiangle.bigevent;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jiangle.bigevent.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import com.auth0.jwt.JWTCreator.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
//@SpringBootTest(classes = BigEventApplication.class)
@SpringBootTest
public final class JwtTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testGen() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "zhangsan");
        Builder builder = JWT.create();
        String token = builder
                .withClaim("user", map) // 添加载荷（payload）
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))   // 过期时间
                .sign(Algorithm.HMAC256("jiangle")  // 指定算法配置秘钥
                );
        System.out.println(token);
    }

    @Test
    public void testParseToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDE2MjY5OTQsInVzZXIiOnsibmFtZSI6InpoYW5nc2FuIiwiaWQiOjF9fQ.IIx_LVixTHwsio81N-94YXoCOzpHdCKGk5vJp5NfRI8";
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("jiangle")).build();
        DecodedJWT verify = verifier.verify(token);
        System.out.println(verify.getClaims());
        /*
         * 1. 篡改token头部或载荷的数据，验证会失败
         * 2. 篡改秘钥，验证会失败
         * 3. token过期，秘钥会验证失败
         * */
    }

    @Test
    public void testJwtUtils(){
        System.out.println(JwtUtils.getExpirationTime());
    }

}
