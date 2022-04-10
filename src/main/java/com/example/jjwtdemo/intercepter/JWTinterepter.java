package com.example.jjwtdemo.intercepter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.jjwtdemo.util.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTinterepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();

        //获取请求头中的令牌
        String token = request.getHeader("token");
        System.out.println("token:"+token);
        try {
            JWTUtils.verifyToken(token);
            return true;
        } catch (TokenExpiredException tokenExpiredException){
            map.put("msg","token过期");
        }catch (AlgorithmMismatchException algorithmMismatchException){
            map.put("msg","token算法不一致");
        }catch (Exception e){
            map.put("msg","token无效");
        }
        map.put("state",false);

        String s = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charest=UTF-8");
        response.getWriter().println(s);
        return false;
    }
}
