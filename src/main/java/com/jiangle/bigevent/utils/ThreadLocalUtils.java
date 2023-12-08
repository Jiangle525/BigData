package com.jiangle.bigevent.utils;

public class ThreadLocalUtils {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    // 存储值
    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    // 获取值
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    // 清除ThreadLocal，防止内存泄露
    public static void remove() {
        THREAD_LOCAL.remove();
    }

}
