package com.example.jjwtdemo.config;

import com.example.jjwtdemo.intercepter.JWTinterepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTinterepter())
                .addPathPatterns("/user/test")
                .excludePathPatterns("/user/login");
    }
}
