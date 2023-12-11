package com.jiangle.bigevent;

import com.alibaba.fastjson.JSONObject;
import com.jiangle.bigevent.pojo.User;
import com.jiangle.bigevent.utils.JsonUtils;
import com.jiangle.bigevent.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BigEventApplicationTests {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class My {
        private String name;
        private User user;

    }

    @Test
    public void testJwtUtils() {
        System.out.println(JwtUtils.getExpirationTime());
    }

    @Test
    public void BeanUtilsTest() {
        My my = new My();
        my.setName("123");
        my.setUser(new User());
//        user.setPassword("123");
        Map<String, String> map = null;
        System.out.println(my);

    }

    @Test
    public void JsonTest() {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("secret");
        HashMap hashMap = JSONObject.parseObject(JSONObject.toJSONString(user), HashMap.class);
        System.out.println(hashMap);

    }

    @Test
    public void JsonUtilsTest() {
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("secret");
        HashMap<String, Object> map = JsonUtils.object2HashMap(user);
        System.out.println(map);
        User u = (User) JsonUtils.hashMap2Object(map, User.class);
        System.out.println(u);
    }
}
