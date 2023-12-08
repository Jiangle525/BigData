package com.jiangle.bigevent.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;

public class JsonUtils {
    // 对象转为HashMap
    public static <T> HashMap<String, T> object2HashMap(T object) {
        return JSONObject.parseObject(JSONObject.toJSONString(object), new TypeReference<HashMap<String, T>>() {
        });
    }

    // HashMap转为指定对象
    public static <T> T hashMap2Object(HashMap map, Class<T> clazz) {
        return JSONObject.parseObject(JSONObject.toJSONString(map), clazz);

    }

}
