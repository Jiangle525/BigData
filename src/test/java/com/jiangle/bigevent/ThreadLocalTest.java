package com.jiangle.bigevent;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    @Test
    public void testThreadLocal(){
        ThreadLocal tl = new ThreadLocal();

        new Thread(()->{
            tl.set("111");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            }
        },"线程1").start();

        new Thread(()->{
            tl.set("222");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            }
        },"线程2").start();
    }
}
