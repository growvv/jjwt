package com.example.jjwtdemo;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.jjwtdemo.util.JWTUtils;

import java.util.HashMap;

@SpringBootTest
class JjwtDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        JWTUtils jwtUtils = new JWTUtils();
        HashMap<String, String> payload = new HashMap<>();
        payload.put("alg", "HS256");
        payload.put("typ", "JWT");

        String token = jwtUtils.createToken(payload);
        System.out.println(token);

        DecodedJWT decodedJWT = jwtUtils.verifyToken(token);
        System.out.println("token: " + decodedJWT.getToken());
        System.out.println("header: " + decodedJWT.getHeader());
        System.out.println("payload: " + decodedJWT.getPayload());
        System.out.println("signature: " + decodedJWT.getSignature());


    }

}
