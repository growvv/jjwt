/**
 * @filename:UserController 2019年10月16日
 * @project wallet-sign  V1.0
 * Copyright(c) 2020 BianPeng Co. Ltd. 
 * All right reserved. 
 */
package com.example.jjwtdemo.controller;


import com.example.jjwtdemo.entity.User;
import com.example.jjwtdemo.service.UserService;
import com.example.jjwtdemo.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： API应用KEYAPI接口层</P>
 * @version: V1.0
 * @author: BianPeng
 * @time    2019年10月16日
 *
 */
@RestController
@RequestMapping("/user")
public class UserController  {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Map<String,Object> login(User user, HttpServletResponse response){
        Map<String,Object> retMap = new HashMap<>();

        User userDB = userService.getById (user);
        if(userDB != null){
            Map<String,String> payload = new HashMap<>();
            payload.put("name",user.getName());
            String token = JWTUtils.createToken(payload);
            response.setHeader("token",token);
            retMap.put("state",true);
            retMap.put("token",token);
        }else{
            retMap.put("state",false);
            retMap.put("msg","登录失败");
        }
        return retMap;
    }

    @RequestMapping("/test")
    public Map<String,Object> test(){
        Map<String,Object> retMap = new HashMap<>();

        retMap.put("state",true);
        retMap.put("msg","验签通过");
        return retMap;
    }
}