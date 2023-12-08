package com.jiangle.bigevent;

import com.jiangle.bigevent.utils.JwtUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

@SpringBootApplication
public class BigEventApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BigEventApplication.class, args);
    }

}
