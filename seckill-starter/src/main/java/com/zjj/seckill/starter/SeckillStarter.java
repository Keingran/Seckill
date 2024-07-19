package com.zjj.seckill.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.zjj.seckill"})
@SpringBootApplication
public class SeckillStarter {

    public static void main(String[] args) {
        SpringApplication.run(SeckillStarter.class, args);
    }

}
