package com.example.jjwtdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.jjwtdemo.dao")
public class JjwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JjwtDemoApplication.class, args);
    }

}
