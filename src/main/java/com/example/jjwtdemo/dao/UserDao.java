/**
 * @filename:UserDao 2019年10月16日
 * @project wallet-sign  V1.0
 * Copyright(c) 2020 BianPeng Co. Ltd. 
 * All right reserved. 
 */
package com.example.jjwtdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jjwtdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**   
 * @Description:TODO(API应用KEY数据访问层)
 *
 * @version: V1.0
 * @author: BianPeng
 * 
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
	
}
