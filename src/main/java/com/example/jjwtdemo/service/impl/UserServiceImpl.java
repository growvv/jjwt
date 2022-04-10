/**
 * @filename:UserServiceImpl 2019年10月16日
 * @project wallet-sign  V1.0
 * Copyright(c) 2018 BianPeng Co. Ltd. 
 * All right reserved. 
 */
package com.example.jjwtdemo.service.impl;

import com.example.jjwtdemo.dao.UserDao;
import com.example.jjwtdemo.entity.User;
import com.example.jjwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**   
 * @Description:TODO(API应用KEY服务实现)
 *
 * @version: V1.0
 * @author: BianPeng
 * 
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserDao, User> implements UserService {

//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public User login(User user) {
//        userDao.findByUser(user);
//        return null;
//    }
}