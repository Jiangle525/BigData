package com.jiangle.bigevent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisConnectionTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisConnectionTest() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("user:zs", "张三");
        String s = ops.get("user:zs");
        System.out.println(s);
    }


}
