package com.yong.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yong.a.liang
 */

@SpringBootApplication
public class IotApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        List<String> list = new ArrayList<>();
        return "hello";
    }
}

