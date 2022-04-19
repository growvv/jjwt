package com.example.jjwtdemo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    public  static  String SIGN = "ASDFse@#w";
    /**
     * 生成Token
     * @param map 用户信息（非敏感信息）
     * @return
     */
    public static String createToken(Map<String,String> payload){
        JWTCreator.Builder builder = JWT.create();
        //遍历map 存放到payload
        payload.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        HashMap<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");  // 默认值就是这两个
        header.put("typ", "JWT");
        builder.withHeader(header);

        Calendar cr = Calendar.getInstance();
        cr.add(Calendar.SECOND,100);    //  过期时间 100秒
        System.out.println(cr.getTime());
        builder.withExpiresAt(cr.getTime());                // 设置有效时间（根据业务需求这是有效时间）
        return builder.sign(Algorithm.HMAC256(SIGN));     // 加签（配置私钥，防止字符串被篡改）
    }

    /**
     * token 验签
     * token 有效负荷读取
     * @param token
     */
    public static DecodedJWT verifyToken(String token){
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);//创建验证对象
    }
}