package com.jiangle.bigevent.utils;

import java.util.HashMap;

public class TokenUtils {
    // 获取对象：从ThreadLocal中读取对象
    public static <T> T getObject(Class<T> clazz) {
        return ThreadLocalUtils.get();
    }

    // 记录对象：将对象存入ThreadLocal
    public static <T> void setObject(T object) {
        ThreadLocalUtils.set(object);
    }

    // 将对象释放：移除ThreadLocal中存入的对象
    public static void remove() {
        ThreadLocalUtils.remove();
    }

    // 生成token：将对象存入token的payload部分
    public static <T> String genToken(T object) {
        HashMap<String, Object> mapObject = JsonUtils.object2HashMap(object);
        return JwtUtils.getToken(mapObject);
    }

    // 解析token：从token的payload中解析出对象
    public static <T> T parseToken(String token, Class<T> clazz) {
        HashMap stringObjectMap = (HashMap) JwtUtils.parseToken(token);
        Object object = JsonUtils.hashMap2Object(stringObjectMap, clazz);
        if (clazz.isInstance(object)) {
            return clazz.cast(object);
        }
        return null;
    }

}
